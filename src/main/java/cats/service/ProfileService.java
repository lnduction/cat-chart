package cats.service;

import cats.entity.Profile;
import cats.form.SingUpForm;

public interface ProfileService {

    void createProfile(SingUpForm singUpForm);
    Profile findProfileByNameAndPassword(String string, String password);
    boolean nameIsTaken(String name);
}
