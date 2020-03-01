package iv1201.group1.applications.recruitment.service;

public interface SecurityService {
   String findLoggedInUsername();

   boolean isRecruit();

   void autoLogin(String username, String password);
}