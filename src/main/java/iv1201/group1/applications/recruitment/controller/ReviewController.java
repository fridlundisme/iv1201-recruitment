package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;
import iv1201.group1.applications.recruitment.service.ApplicationFormDTO;
import iv1201.group1.applications.recruitment.service.ApplicationService;
import iv1201.group1.applications.recruitment.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for the page where the applicant can review their application.
 */
@Controller
@SessionAttributes("applicationDTO")
public class ReviewController {

   @Autowired
   ApplicationService applicationService;

   @Autowired
   SecurityService securityService;

   /**
    * Function for entering the page and getting the needed functionality to view the application before submitting.
    * @param applicationFormDTO gives the information about competences and availability.
    * @param model gives information about the applicant.
    * @return returns the requested view review.
    */
   @GetMapping("/review")
   public String review(@ModelAttribute("applicationDTO") ApplicationFormDTO applicationFormDTO, Model model) {
      model.addAttribute("applicationDTO", applicationFormDTO);
      return "review";
   }

   /**
    * Function for adding information to the database and sending the applicant to the next view, the index page.
    * @param applicationFormDTO gives the information about competences and availability.
    * @return the page index.
    */
   @PostMapping("/review")
   public String review(@ModelAttribute("applicationDTO") ApplicationFormDTO applicationFormDTO) {
      for (Availability availability : applicationFormDTO.getAvailabilityList()) {
         applicationService.save(availability, securityService.findLoggedInUsername());
      }

      for (CompetenceProfile competenceProfile : applicationFormDTO.getCompetenceProfileList()) {
         applicationService.save(competenceProfile, securityService.findLoggedInUsername());
      }

      return "index";
   }

   /**
    * A get for applicationDTO
    * @return returns application DTO.
    */
   @ModelAttribute
   public ApplicationFormDTO applicationDTO() {
      return new ApplicationFormDTO();
   }
}
