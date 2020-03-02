package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;
import iv1201.group1.applications.recruitment.service.ApplicationService;
import iv1201.group1.applications.recruitment.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("applicationDTO")
public class ReviewController {

   @Autowired
   ApplicationService applicationService;

   @Autowired
   SecurityService securityService;

   @GetMapping("/review")
   public String review(@ModelAttribute("applicationDTO") ApplicationFormDTO applicationFormDTO, Model model, RedirectAttributes redirectAttributes) {
      model.addAttribute("applicationDTO", applicationFormDTO);
      return "review";
   }

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

   @ModelAttribute
   public ApplicationFormDTO applicationDTO() {
      return new ApplicationFormDTO();
   }
}
