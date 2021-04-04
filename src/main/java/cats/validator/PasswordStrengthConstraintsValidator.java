package cats.validator;

import cats.annotation.constraints.PasswordStrength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordStrengthConstraintsValidator implements ConstraintValidator<PasswordStrength, String> {



    @Override
    public void initialize(PasswordStrength passwordStrength) { }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) { return true; }
}
