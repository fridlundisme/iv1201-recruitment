package iv1201.group1.applications.recruitment.service;

public interface SecurityService {
   String findLoggedInUsername();

   void autoLogin(String username, String password);
}