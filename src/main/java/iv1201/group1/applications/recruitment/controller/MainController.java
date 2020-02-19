package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import iv1201.group1.applications.recruitment.domain.Person;

@Controller
public class MainController{
    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index"})
    public String index(Model model){
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("registrationForm", new Person());
        return "registration";
    }
}