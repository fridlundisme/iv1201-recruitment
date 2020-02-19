package iv1201.group1.applications.recruitment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.service.SecurityService;
import iv1201.group1.applications.recruitment.service.UserService;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("registrationForm") @Valid Person users, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ModelAndView("registration","registrationForm",users);
        }

        return new ModelAndView("index");
        // if (bindingResult.hasErrors())
        //     return "registration";

        // System.out.println(users.toString());

        // userService.save(users);

        // securityService.autoLogin(users.getUsername(), users.getPassword());

    }
}