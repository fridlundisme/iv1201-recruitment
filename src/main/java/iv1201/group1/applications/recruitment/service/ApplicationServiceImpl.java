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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * implementations of services/functions from the interface for handling competences and availability in the
 * application.
 */
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

   /**
    * Get for competences.
    * @return returns a list of available competences from the database.
    */
   @Override
   @Transactional(readOnly = true)
   public List<Competence> getCompetenceList() {
      return competenceJpaRepository.findAll();
   }

   /**
    * Get for competence found by name.
    * @param competence
    * @return returns competence.
    */
   @Override
   @Transactional(readOnly = true)
   public Competence getCompetenceByName(String competence) {
      return competenceJpaRepository.findByName(competence);
   }

   /**
    * Function for saving (adding to database) availability to the given person found by username.
    * @param availability
    * @param username
    */
   @Override
   @Transactional(isolation = Isolation.SERIALIZABLE)
   public void save(Availability availability, String username) {
      availability.setPerson(personJpaRepository.findByUsername(username));
      availabilityJpaRepository.save(availability);
   }

   /**
    * Function for saving (adding to database) competence profile to given person found by username.
    * @param competenceProfile
    * @param username
    */
   @Override
   @Transactional(isolation = Isolation.SERIALIZABLE)
   public void save(CompetenceProfile competenceProfile, String username) {
      competenceProfile.setPerson(personJpaRepository.findByUsername(username));
      competenceProfileJpaRepository.save(competenceProfile);
   }
}
