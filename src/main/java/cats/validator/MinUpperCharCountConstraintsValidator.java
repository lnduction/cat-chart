package cats.validator;

import cats.annotation.constraints.MinUpperCharCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinUpperCharCountConstraintsValidator implements ConstraintValidator<MinUpperCharCount, String> {

    private int UpperCharCount;

    @Override
    public void initialize(MinUpperCharCount minUpperCharCount) {
        this.UpperCharCount = minUpperCharCount.value();
    }

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        int count = 0;
        for(int i = 0; i < s.length(); i++) if (LETTERS.indexOf(s.charAt(i)) != -1) count++;
        return count >= UpperCharCount;
    }
}
