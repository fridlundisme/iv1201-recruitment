package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.Competence;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;
import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Controller
public class ApplicationController {

   @Autowired
   private ApplicationService applicationService;


   @GetMapping("/apply")
   public String apply(Model model) {
      model.addAttribute("competenceList", applicationService.getCompetenceList());
      return "apply";
   }

   @PostMapping("/apply")
   public String apply(Model model, @RequestParam(value = "competences") String[] competences, @RequestParam(value = "yearsOfExperienceList") int[] yearsOfExperienceList, @RequestParam(value = "fromDate") Date[] fromDateList, @RequestParam(value = "toDate") Date[] toDateList, RedirectAttributes redirectAttributes) {
      ApplicationFormDTO applicationFormDTO = new ApplicationFormDTO();
      ArrayList<CompetenceProfile> competenceProfiles = new ArrayList<>();
      ArrayList<Availability> availabilities = new ArrayList<>();

      for (int i = 0; i < competences.length; i++) {
         CompetenceProfile tempCompetenceProfile = new CompetenceProfile();
         tempCompetenceProfile.setYearsOfExperience(yearsOfExperienceList[i]);
         tempCompetenceProfile.setCompetence(applicationService.getCompetenceByName(competences[i]));
         competenceProfiles.add(tempCompetenceProfile);
      }

      for (int i = 0; i < fromDateList.length; i++) {
         Availability tempAvailability = new Availability();
         tempAvailability.setFromDate(fromDateList[i]);
         tempAvailability.setToDate(toDateList[i]);
         availabilities.add(tempAvailability);
      }

      applicationFormDTO.setCompetenceProfileList(competenceProfiles);
      applicationFormDTO.setAvailabilityList(availabilities);
      redirectAttributes.addFlashAttribute("applicationDTO", applicationFormDTO);

      return "redirect:review";
   }
}
