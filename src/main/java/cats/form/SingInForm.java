package cats.form;

import cats.entity.Profile;

import javax.validation.Valid;

public class SingInForm {

    @Valid
    private Profile item;

    public Profile getItem() { return item; }
    public void setItem(Profile item) { this.item = item; }
}
