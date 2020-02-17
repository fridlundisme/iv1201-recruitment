package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Users;

public interface UserService {
   void save(Users users);

   Users findByUsername(String username);
}
