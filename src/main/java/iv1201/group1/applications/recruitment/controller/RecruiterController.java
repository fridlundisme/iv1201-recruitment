package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecruiterController {



   //Hire Applicant
   public void hireApplicant() {

   }

   //deny Applicant
   public void denyApplicant() {

   }

   //show detailed view of chosen applicant
   @PostMapping("/recruit")
   public String viewApplicant(Person person) {
      int personId = person.getPersonId();
      return "applicantView." + personId;
   }
}
