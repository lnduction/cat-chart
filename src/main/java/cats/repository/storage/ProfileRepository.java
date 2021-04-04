package cats.repository.storage;

import cats.entity.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {

    Profile findByNameAndPassword(String name, String password);
    int countByName(String name);


}
