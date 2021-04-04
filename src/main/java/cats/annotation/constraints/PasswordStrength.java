package cats.annotation.constraints;

import cats.validator.PasswordStrengthConstraintsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PasswordStrengthConstraintsValidator.class})
@Size(min=8, message = "Min 8 letter!")
@MinDigitCount
@MinUpperCharCount
@MinLowerCharCount
@MinSpecCharCount
public @interface PasswordStrength {

    String message() default "PasswordStrength";
    Class<? extends Payload>[] payload() default { };
    Class<?>[] groups() default { };
}
