package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.Competence;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;

import java.util.List;

public class ApplicationFormDTO {
   public List<CompetenceProfile> competenceProfileList;
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
