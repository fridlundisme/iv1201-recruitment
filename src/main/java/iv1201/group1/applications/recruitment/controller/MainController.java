package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.service.ApplicationService;
import iv1201.group1.applications.recruitment.service.SecurityService;
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

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("isRecruit", securityService.isRecruit());
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationForm", new Person());
        return "registration";
    }

    @GetMapping("/apply")
    public String apply(Model model) {
        model.addAttribute("competenceList", applicationService.getCompetenceList());
        model.addAttribute("applicationForm");
        return "apply";
    }

    @GetMapping("/review")
    public String review() {return "review"; }
}