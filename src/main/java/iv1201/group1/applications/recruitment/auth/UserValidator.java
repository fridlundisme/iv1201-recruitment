package iv1201.group1.applications.recruitment.auth;

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
