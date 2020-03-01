package iv1201.group1.applications.recruitment.controller;
/**
 * Comments later
 * */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes({"currentUser"})
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";

    }
}

