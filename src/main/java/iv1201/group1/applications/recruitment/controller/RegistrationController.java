package iv1201.group1.applications.recruitment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.service.SecurityServiceImpl;
import iv1201.group1.applications.recruitment.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Handles all the registration requests
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityServiceImpl securityService;



        
    /** 
     * Catches the registration site and provides it with a new object, Person, that handles the registration requests.
     * @param model
     * @return String
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationForm", new Person());
        return "registration";
    }
    
    /** 
     * Controls the registration form that an end user posts.
     * @param registerPerson The instance of Person that is filled out in the registrationForm
     * @param bindingResult result of the post request
     * @return The correct new page
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("registrationForm") @Valid Person registerPerson, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "registration";

        userService.save(registerPerson);
        securityService.autoLogin(registerPerson.getUsername(), registerPerson.getPassword());

        return "redirect:apply";
    }
}