package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ApplicationController {

   @PostMapping("/apply")
   public String apply(Model model) {

      //userService.save(applicationForm);

      //securityService.autoLogin(applicationForm.getUsername(), applicationForm.getPassword());

      return "redirect:review";
   }
}
