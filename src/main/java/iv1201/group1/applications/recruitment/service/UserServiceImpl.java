package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Users;
import iv1201.group1.applications.recruitment.model.RoleJparepository;
import iv1201.group1.applications.recruitment.model.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserJpaRepository userJpaRepository;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
   public void save(Users users) {
      users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
      userJpaRepository.save(users);
   }

   @Override
   public Users findByUsername(String username) {
      return userJpaRepository.findByUsername(username);
   }
}
