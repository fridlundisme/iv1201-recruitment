package iv1201.group1.applications.recruitment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.service.SecurityServiceImpl;
import iv1201.group1.applications.recruitment.service.UserService;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityServiceImpl securityService;


    @PostMapping("/registration")
    public String registration(@ModelAttribute("registrationForm") @Valid Person registerPerson, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "registration";

        System.out.println(registerPerson.toString());

        userService.save(registerPerson);

        securityService.autoLogin(registerPerson.getUsername(), registerPerson.getPassword());

        return "index";
    }
}