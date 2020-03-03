package iv1201.group1.applications.recruitment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the functions/services that handles details
 * that is used for login in or check the person that is logged in.
 */
@Service
public class SecurityServiceImpl implements SecurityService {
   
   @Autowired
   private AuthenticationManager authenticationManager;

   @Qualifier("userDetailsServiceImpl")
   @Autowired
   private UserDetailsService userDetailsService;

   /**
    * Function for getting username of the person that is logged in.
    * @return username of the person that is logged in.
    */
   @Override
   public String findLoggedInUsername() {
      Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if (userDetails instanceof UserDetails) {
         return ((UserDetails) userDetails).getUsername();
      }
      return userDetails.toString();
   }

   /**
    * Function that checks if person is recruiter or applicant.
    * @return returns true if recruiter or false if applicant.
    */
   @Override
   @Transactional
   public boolean isRecruit() {
      return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("recruit"));
   }

   /**
    * Function for login, takes login parameters and tries to login.
    * @param username
    * @param password
    */
   @Override
   @Transactional
   public void autoLogin(String username, String password) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

      authenticationManager.authenticate(usernamePasswordAuthenticationToken);

      if(usernamePasswordAuthenticationToken.isAuthenticated()) {
         SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

      }
   }
}
