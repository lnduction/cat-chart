package cats.annotation.constraints;

import cats.validator.EnglishLanguageConstraintValidator;

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
@Constraint(validatedBy = { EnglishLanguageConstraintValidator.class})
public @interface EnglishLanguage {

    String message() default "EnglishLanguage";
    boolean withNumbers() default true; //0123456789
    boolean withPunctuations() default true;  //.,?!-:()'"[]{}; \t\n
    boolean withSpechSymbols() default true; //~#$%^&*-+=_\\|/@`!'\";:><,.?{}

    Class<? extends Payload>[] payload() default { };
    Class<?>[] groups() default { };
}
