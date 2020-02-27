package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.model.RoleJpaRepository;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private PersonJpaRepository personJpaRepository;

   @Autowired
   private RoleJpaRepository roleJpaRepository;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
   public void save(Person person) {
      person.setRole(roleJpaRepository.findByName("applicant"));
      person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
      personJpaRepository.save(person);
   }

   @Override
   public Person findByUsername(String username) {
      return personJpaRepository.findByUsername(username);
   }
}
