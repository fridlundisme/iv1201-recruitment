package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;

/**
 * Functions to handle the table person in the database.
 */
public interface UserService {

   void save(Person person);

   Person findByUsername(String username);

   boolean userExists(String user);
}
