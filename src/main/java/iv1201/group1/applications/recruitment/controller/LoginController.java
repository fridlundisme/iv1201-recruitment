package iv1201.group1.applications.recruitment.controller;

/**
 * Comments later
 * */

import iv1201.group1.applications.recruitment.domain.Currency;
import iv1201.group1.applications.recruitment.domain.Db;
import iv1201.group1.applications.recruitment.domain.User;
import iv1201.group1.applications.recruitment.integration.Integration;
import iv1201.group1.applications.recruitment.model.ModelNotinuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@SessionAttributes({"currentUser"})
@Controller
public class LoginController {
    ModelNotinuse model = new ModelNotinuse();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, @ModelAttribute Currency db) {
        // model.addAttribute("db", new Db());
        String s = Integration.select();
        db.setSum(2000);

        return "test";
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

