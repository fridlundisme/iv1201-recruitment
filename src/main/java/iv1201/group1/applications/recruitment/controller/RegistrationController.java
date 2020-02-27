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
    public String registration(@ModelAttribute("registrationForm") @Valid Person registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "registration";

        userService.save(registrationForm);

        securityService.autoLogin(registrationForm.getUsername(), registrationForm.getPassword());

        return "index";
    }
}