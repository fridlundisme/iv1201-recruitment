package iv1201.group1.applications.recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import iv1201.group1.applications.recruitment.domain.Person;

@Controller
public class MainController{

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("registrationForm", new Person());
        return "registration";
    }
}