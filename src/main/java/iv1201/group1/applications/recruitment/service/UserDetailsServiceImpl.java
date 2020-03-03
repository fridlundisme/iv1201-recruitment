package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.model.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementations of functions that handles the table person in the database.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
   private PersonJpaRepository personJpaRepository;

   /**
    * Function for loading in a person by username.
    * @param username
    * @return returns the username, password and the authorities for the user.
    */
   @Override
   @Transactional(readOnly = true)
   public UserDetails loadUserByUsername(String username) {
      Person user = personJpaRepository.findByUsername(username);
      if (user == null) throw new UsernameNotFoundException(username);

      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

      grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

      return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
   }
}
