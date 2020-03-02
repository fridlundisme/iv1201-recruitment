package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.Competence;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;

import java.util.List;

/**
 * DTO handling the form for adding availabilities and competences.
 */
public class ApplicationFormDTO {
   /**
    * List of competence profiles
    */
   public List<CompetenceProfile> competenceProfileList;

   /**
    * List of availabilities
    */
   public List<Availability> availabilityList;

   public List<CompetenceProfile> getCompetenceProfileList() {
      return competenceProfileList;
   }

   public void setCompetenceProfileList(List<CompetenceProfile> competenceProfileList) {
      this.competenceProfileList = competenceProfileList;
   }

   public List<Availability> getAvailabilityList() {
      return availabilityList;
   }

   public void setAvailabilityList(List<Availability> availabilityList) {
      this.availabilityList = availabilityList;
   }
}
