package iv1201.group1.applications.recruitment.exceptionhandling.validation;

/**
 * This validator is copied from Baeldungs tutorial on Spring mvc validation
 * @see
 * <a href="www.baeldungs.com">Baeldungs tutorial</a>
 */

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Creates a new Annotation that exists to control the Email validation
 * @see
 * EmailValidator
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {   
    String message() default "Invalid email";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};
}