package iv1201.group1.applications.recruitment.service;

/**
 * Services/functions that handles login or checking authority of logged in person.
 */
public interface SecurityService {
   String findLoggedInUsername();

   boolean isRecruit();

   void autoLogin(String username, String password);
}