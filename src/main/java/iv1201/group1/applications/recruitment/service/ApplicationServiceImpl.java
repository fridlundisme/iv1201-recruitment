package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Competence;
import iv1201.group1.applications.recruitment.model.AvailabilityJpaRepository;
import iv1201.group1.applications.recruitment.model.CompetenceJpaRepository;
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

   @Override
   @Transactional(readOnly = true)
   public List<Competence> getCompetenceList() {
      return competenceJpaRepository.findAll();
   }
}
