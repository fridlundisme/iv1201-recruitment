package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RecruitmentServiceImpl implements RecruitmentService {

   @Autowired
   private PersonJpaRepository personJpaRepository;
   
   @Override
   @Transactional(readOnly = true)
   public List<Person> getPersonList() { return PersonJpaRepository.findAllByRoleId(2); }


}
