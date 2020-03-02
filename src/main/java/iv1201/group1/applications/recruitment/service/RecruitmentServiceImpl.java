package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implements functions/services that handles recruitment.
 */
public class RecruitmentServiceImpl implements RecruitmentService {

   @Autowired
   private PersonJpaRepository personJpaRepository;

   /**
    * A function for getting the list of applications.
    * @return returns a list of persons that has the role applicant.
    */
   @Override
   @Transactional(readOnly = true)
   public List<Person> getPersonList() { return PersonJpaRepository.findAllByRoleId(2); }


}
