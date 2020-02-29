package iv1201.group1.applications.recruitment.exceptionhandling.validation;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {   
    String message() default "Invalid email";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};
}