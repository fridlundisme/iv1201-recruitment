package iv1201.group1.applications.recruitment.controller;

/**
 * Comments later
 * */

import iv1201.group1.applications.recruitment.domain.Currency;
import iv1201.group1.applications.recruitment.domain.Users;
import iv1201.group1.applications.recruitment.model.ModelNotinuse;
import iv1201.group1.applications.recruitment.model.UserJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
=======
import org.springframework.web.bind.annotation.*;
import java.util.*;
>>>>>>> 40beb5940421d489eb7114637c5704eacec0c3c2

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private UserJpaRepository userjpa;

    @GetMapping(value = "/login")
<<<<<<< HEAD
    public String login() {
        return "testlogin";
=======
    public List<Users> login() {
        List<Users> usrs =  userjpa.findAll();
        return usrs;
>>>>>>> 40beb5940421d489eb7114637c5704eacec0c3c2
    }
    // @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    // public String postLogin(Model model, HttpSession session) {
    //     UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    //     validatePrinciple(authentication.getPrincipal());
    //     User loggedInUser = ((UserDetails) authentication.getPrincipal()).getUserDetails();
    //     model.addAttribute("currentUser", loggedInUser.getUsername());
    //     session.setAttribute("userId", loggedInUser.getId());
    //     return "redirect:/wallPage";
    // }


    private void validatePrinciple(Object principal) {
        if (!(principal instanceof UserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }

    /**
     * Attempt to login has been made
     * */
    /*boolean tryLogin(LoginDetails loginDetails){
        return model.loginAttempt(loginDetails);
    }*/

}

