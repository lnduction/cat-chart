package cats.service.impl;

import cats.entity.Profile;
import cats.form.SingUpForm;
import cats.repository.storage.ProfileRepository;
import cats.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired private ProfileRepository profileRepository;

    @Override
    @Transactional
    public void createProfile(SingUpForm singUpForm) {
        Profile profile = new Profile();
        profile.setName(singUpForm.getName());
        profile.setPassword(singUpForm.getPassword());
        profileRepository.save(profile);

    }

    @Override
    public Profile findProfileByNameAndPassword(String name, String password) {
        return profileRepository.findByNameAndPassword(name, password);
    }

    @Override
    public boolean nameIsTaken(String name) {
        return profileRepository.countByName(name) > 0;
    }
}
