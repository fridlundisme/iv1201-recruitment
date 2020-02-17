package iv1201.group1.applications.recruitment.controller;

/**
 * Comments later
 * */

import iv1201.group1.applications.recruitment.domain.Users;
import iv1201.group1.applications.recruitment.model.UserJpaRepository;

import iv1201.group1.applications.recruitment.service.SecurityService;
import iv1201.group1.applications.recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public String login(Model model) {
        return "testlogin";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationForm", new Users());
        return "registration";

    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("registrationForm") Users registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "registration";

        System.out.println(registrationForm.toString());

        userService.save(registrationForm);

        securityService.autoLogin(registrationForm.getUsername(), registrationForm.getPassword());

        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

//    @Autowired
//    private UserJpaRepository userjpa;
//
//    @GetMapping(value = "/login")
//    public List<Users> login() {
//        List<Users> usrs =  userjpa.findAll();
//        return usrs;
//    }
//    @PostMapping(value = "/postLogin")
//    public String postLogin(Model model, HttpSession session) {
//        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        validatePrinciple(authentication.getPrincipal());
//        User loggedInUser = ((UserDetails) authentication.getPrincipal()).getUserDetails();
//        model.addAttribute("currentUser", loggedInUser.getUsername());
//        session.setAttribute("userId", loggedInUser.getId());
//        return "redirect:/wallPage";
//     }
//
//
//    private void validatePrinciple(Object principal) {
//        if (!(principal instanceof UserDetails)) {
//            throw new  IllegalArgumentException("Principal can not be null!");
//        }
//    }

    /**
     * Attempt to login has been made
     * */
    /*boolean tryLogin(LoginDetails loginDetails){
        return model.loginAttempt(loginDetails);
    }*/

}

