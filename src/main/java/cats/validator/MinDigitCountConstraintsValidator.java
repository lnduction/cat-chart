package cats.validator;

import cats.annotation.constraints.MinDigitCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinDigitCountConstraintsValidator implements ConstraintValidator<MinDigitCount, String> {

    private int digitCount;
    @Override
    public void initialize(MinDigitCount minDigitCount) {
        this.digitCount = minDigitCount.value();
    }

    private static final String NUMBERS = "0123456789";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        int count = 0;
        for(int i = 0; i < s.length(); i++) if (NUMBERS.indexOf(s.charAt(i)) != -1) count++;
        return count >= digitCount;
    }
}
