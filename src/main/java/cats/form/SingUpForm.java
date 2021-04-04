package cats.form;

import cats.annotation.constraints.EnglishLanguage;
import cats.annotation.constraints.PasswordStrength;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SingUpForm {

    @Valid
    @NotNull
    @EnglishLanguage(message = "Use english language!")
    private String name;
    @NotNull
    @PasswordStrength
    private String password;
    @NotNull
    private String confirmPassword;

    private boolean fieldMatch;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
        setFieldMatch();
    }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
       setFieldMatch();
    }

    private void setFieldMatch() {
        fieldMatch = password != null && password.equals(confirmPassword);
    }

    public boolean isFieldMatch() { return fieldMatch; }
}
