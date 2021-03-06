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
    
    /**
     * Catches the "/" and "/index" sites and maps them.
     * @return The index page
     */
    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }
}