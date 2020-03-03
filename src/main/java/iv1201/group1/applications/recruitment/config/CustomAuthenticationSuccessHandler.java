package iv1201.group1.applications.recruitment.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
/**
 * Implements {@link AuthenticationSuccessHandler}
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

   
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
      handle(request, response, authentication);
      clearAuthenticationAttributes(request);
   }

   protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
      String targetUrl = determineTargetUrl(authentication);

      if (response.isCommitted()) {
         return;
      }
      redirectStrategy.sendRedirect(request, response, targetUrl);
   }

   
   protected String determineTargetUrl(Authentication authentication) {
      boolean isApplicant = false;
      boolean isRecruit = false;
      Collection<? extends GrantedAuthority> authorities
              = authentication.getAuthorities();
      for (GrantedAuthority grantedAuthority : authorities) {
         if (grantedAuthority.getAuthority().equals("applicant")) {
            isApplicant = true;
            break;
         } else if (grantedAuthority.getAuthority().equals("recruit")) {
            isRecruit = true;
            break;
         }
      }

      if (isApplicant) {
         return "index";
      } else if (isRecruit) {
         return "index";
      } else {
         throw new IllegalStateException();
      }
   }

   
   protected void clearAuthenticationAttributes(HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      if (session == null) {
         return;
      }
      session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
   }

   
   public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
      this.redirectStrategy = redirectStrategy;
   }
   
   protected RedirectStrategy getRedirectStrategy() {
      return redirectStrategy;
   }
}
