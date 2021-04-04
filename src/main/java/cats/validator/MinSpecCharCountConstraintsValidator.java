package cats.validator;

import cats.annotation.constraints.MinSpecCharCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinSpecCharCountConstraintsValidator implements ConstraintValidator<MinSpecCharCount, String> {

    private String LETTERS;
    private int specCharCount;

    @Override
    public void initialize(MinSpecCharCount minSpecCharCount) {
        this.LETTERS = minSpecCharCount.specSymbols();
        this.specCharCount = minSpecCharCount.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        int count = 0;
        for(int i = 0; i < s.length(); i++) if (LETTERS.indexOf(s.charAt(i)) != -1) count++;
        return count >= specCharCount;
    }
}
