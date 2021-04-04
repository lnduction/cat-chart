package cats.validator;

import cats.annotation.constraints.MinLowerCharCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinLowerCharCountConstraintsValidator implements ConstraintValidator<MinLowerCharCount, String> {

    private int lowerCharCount;
    @Override
    public void initialize(MinLowerCharCount minLowerCharCount) {
       this.lowerCharCount = minLowerCharCount.value();
    }

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        int count = 0;
        for(int i = 0; i < s.length(); i++) if (LETTERS.indexOf(s.charAt(i)) != -1) count++;
        return count >= lowerCharCount;
    }
}
