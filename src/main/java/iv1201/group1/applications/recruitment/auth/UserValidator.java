package iv1201.group1.applications.recruitment.auth;

import iv1201.group1.applications.recruitment.domain.Users;
import iv1201.group1.applications.recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/*
@Component
public class UserValidator implements Validator {
   @Autowired
   private UserService userService;

   @Override
   public boolean supports(Class<?> aClass) {
      return Users.class.equals(aClass);
   }

   @Override
   public void validate (Object o, Errors errors) {
      Users users = (Users) o;

      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
      if (users.getUsername().length() < 6 || users.getUsername().length() > 32) {
         errors.rejectValue("username", "Size.userForm.username");
      }
   }
}*/
