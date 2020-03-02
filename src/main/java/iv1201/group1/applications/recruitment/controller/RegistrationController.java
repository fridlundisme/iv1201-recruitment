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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("registrationForm") @Valid Person registrationForm, BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors())
            return modelAndView;

        //userService.save(registrationForm);
        modelAndView.setViewName("apply");
        //securityService.autoLogin(registrationForm.getUsername(), registrationForm.getPassword());

        return modelAndView;
    }
}