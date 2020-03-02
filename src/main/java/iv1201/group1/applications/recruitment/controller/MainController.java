package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the most general pages
 */
@Controller
public class MainController{
    @Autowired
    private SecurityService securityService;

    
    /**
     * Catches the "/" and "/index" sites and mapps them.
     * @param model
     * @return The index page
     */
    @GetMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("isRecruit", securityService.isRecruit());
        return "index";
    }

    
    /** 
     * Catches the "/recruit" website and mapps it.
     * @param model
     * @return recruit website
     */
    @GetMapping({"/recruit"})
    public String recruit(Model model){
        return "recruit";
    }

    /**
     * Catches the apply website
     * @return apply site
     */
    @GetMapping("/apply")
    public String apply() {return "apply"; }
}