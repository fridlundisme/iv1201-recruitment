package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;

public interface UserService {

   void save(Person person);

   Person findByUsername(String username);

   boolean userExists(String user);
}
