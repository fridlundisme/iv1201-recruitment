package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.error.UserAlreadyExistException;
import iv1201.group1.applications.recruitment.model.RoleJpaRepository;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private PersonJpaRepository personJpaRepository;

   @Autowired
   private RoleJpaRepository roleJpaRepository;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
   @Transactional(isolation = Isolation.SERIALIZABLE)
   public void save(Person person) {
      if(userExists(person.getUsername())){
         throw new UserAlreadyExistException("Username taken " + person.getUsername());
      }
      person.setRole(roleJpaRepository.findByName("applicant"));
      person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
      personJpaRepository.save(person);
   }

   @Override
   @Transactional(readOnly = true)
   public Person findByUsername(String username) {
      return personJpaRepository.findByUsername(username);
   }

   @Override
   public boolean userExists(String username) {
      return personJpaRepository.findByUsername(username) != null;
   }
}
