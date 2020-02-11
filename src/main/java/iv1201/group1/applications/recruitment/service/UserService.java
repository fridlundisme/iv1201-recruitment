package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Users;

public interface UserService {
   void save(Users user);
   Users findByUsername(String username);
}
