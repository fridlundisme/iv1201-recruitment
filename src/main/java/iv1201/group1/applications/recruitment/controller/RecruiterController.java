package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Class for handling the recruiter view and its functionality.
 */
@Controller
public class RecruiterController {


   /**
    * Function for accepting the applicant
    */
   //Hire Applicant
   public void hireApplicant() {

   }

   /**
    * Function for denying the applicant
    */
   //deny Applicant
   public void denyApplicant() {

   }

   /**
    * Function for getting the page that views one specific application.
    * @param person is the applicant.
    * @return returns the requested view.
    */
   //show detailed view of chosen applicant
   @PostMapping("/recruit")
   public String viewApplicant(Person person) {
      int personId = person.getPersonId();
      return "applicantView." + personId;
   }
}
