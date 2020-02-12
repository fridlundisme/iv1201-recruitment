package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Users;
import iv1201.group1.applications.recruitment.model.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
   private UserJpaRepository userJpaRepository;

   @Override
   @Transactional(readOnly = true)
   public UserDetails loadUserByUsername(String username) {
      Users user = userJpaRepository.findByUsername(username);
      if (user == null) throw new UsernameNotFoundException(username);

      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
   }
}