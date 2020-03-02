package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.Competence;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;
import iv1201.group1.applications.recruitment.domain.Person;

import java.util.List;

public interface ApplicationService {
   List<Competence> getCompetenceList();

   Competence getCompetenceByName(String competence);

   void save(Availability availability, String username);

   void save(CompetenceProfile competenceProfile, String username);
}
