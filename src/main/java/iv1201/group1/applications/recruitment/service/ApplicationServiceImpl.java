package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Availability;
import iv1201.group1.applications.recruitment.domain.Competence;
import iv1201.group1.applications.recruitment.domain.CompetenceProfile;
import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.model.AvailabilityJpaRepository;
import iv1201.group1.applications.recruitment.model.CompetenceJpaRepository;
import iv1201.group1.applications.recruitment.model.CompetenceProfileJpaRepository;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
   @Autowired
   private CompetenceJpaRepository competenceJpaRepository;

   @Autowired
   private PersonJpaRepository personJpaRepository;

   @Autowired
   private AvailabilityJpaRepository availabilityJpaRepository;

   @Autowired
   private CompetenceProfileJpaRepository competenceProfileJpaRepository;

   @Override
   @Transactional(readOnly = true)
   public List<Competence> getCompetenceList() {
      return competenceJpaRepository.findAll();
   }

   @Override
   @Transactional
   public Competence getCompetenceByName(String competence) {
      return competenceJpaRepository.findByName(competence);
   }

   @Override
   @Transactional
   public void save(Availability availability, String username) {
      availability.setPerson(personJpaRepository.findByUsername(username));
      availabilityJpaRepository.save(availability);
   }

   @Override
   @Transactional
   public void save(CompetenceProfile competenceProfile, String username) {
      competenceProfile.setPerson(personJpaRepository.findByUsername(username));
      competenceProfileJpaRepository.save(competenceProfile);
   }
}
