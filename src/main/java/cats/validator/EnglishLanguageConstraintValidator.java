package cats.validator;

import cats.annotation.constraints.EnglishLanguage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnglishLanguageConstraintValidator implements ConstraintValidator<EnglishLanguage, String> {

    private boolean withNumbers;
    private boolean withPunctuations;
    private boolean withSpechSymbols;

    @Override
    public void initialize(EnglishLanguage constraintAnnotation) {
        this.withNumbers = constraintAnnotation.withNumbers();
        this.withPunctuations = constraintAnnotation.withPunctuations();
        this.withSpechSymbols = constraintAnnotation.withSpechSymbols();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        String validationTemplate = getValidationTemplate();
        for (int i = 0; i < value.length(); i++)
            if (validationTemplate.indexOf(value.charAt(i)) == -1) return false;
        return true;
    }

    private static final String SPETCH_SYMBOLS = "~#$%^&*-+=_\\|/@`!'\";:><,.?{}";
    private static final String PUNCTUATIONS = ".,?!-:()'\"[]{}; \t\n";
    private static final String NUMBERS = "0123456789";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String getValidationTemplate() {
        StringBuilder template = new StringBuilder(LETTERS);
        if (withNumbers) { template.append(NUMBERS); }
        if (withPunctuations) { template.append(PUNCTUATIONS); }
        if (withSpechSymbols) { template.append(SPETCH_SYMBOLS); }
        return template.toString();
    }
}