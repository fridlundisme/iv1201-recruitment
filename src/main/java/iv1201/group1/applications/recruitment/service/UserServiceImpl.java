package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.error.EmailAlreadyExistException;
import iv1201.group1.applications.recruitment.error.UserAlreadyExistException;
import iv1201.group1.applications.recruitment.model.RoleJpaRepository;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * An implementation of functions for handling the table person in the database.
 */
@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private PersonJpaRepository personJpaRepository;

   @Autowired
   private RoleJpaRepository roleJpaRepository;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   /**
    * Function for adding a person to the database, if username is taken then a exception is thrown.
    * @param person is the object that is to be added to the database.
    */
   @Override
   @Transactional(isolation = Isolation.SERIALIZABLE)
   public void save(Person person) {
      if(userExists(person.getUsername())){
         throw new UserAlreadyExistException("Username taken: " + person.getUsername());
      }else if(emailExists(person.getEmail())){
         throw new EmailAlreadyExistException("Email already registered: " + person.getEmail());
      }

      person.setRole(roleJpaRepository.findByName("applicant"));
      person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
      personJpaRepository.save(person);
   }



   /**
    * Function for getting object person by searching on a username.
    * 
    * @param username is the search parameter.
    * @return returns a object person with the given username.
    */
   @Override
   @Transactional(readOnly = true)
   public Person findByUsername(String username) {
      return personJpaRepository.findByUsername(username);
   }

   /**
    * Function for checking if a person with the
    * @param username exists in the database.
    * @return returns a boolean true if person with given username exists.
    */
   @Override
   @Transactional
   public boolean userExists(String username) {
      return personJpaRepository.findByUsername(username) != null;
   }

   @Override
   public boolean emailExists(String email) {
      return personJpaRepository.findByEmail(email) != null;
   }
}
