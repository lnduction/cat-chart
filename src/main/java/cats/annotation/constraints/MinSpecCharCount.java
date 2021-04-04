package cats.annotation.constraints;

import cats.validator.MinSpecCharCountConstraintsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy={MinSpecCharCountConstraintsValidator.class})
public @interface MinSpecCharCount {

    int value() default 1;
    String specSymbols() default "!@~`#$%^&*()_-+=|\\/{}[].,;:/?";
    String message() default "MinSpecCharCount";
    Class<? extends Payload>[] payload() default { };
    Class<?>[] groups() default { };
}
