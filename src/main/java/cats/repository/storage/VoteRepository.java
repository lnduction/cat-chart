package cats.repository.storage;

import cats.entity.Cat;
import cats.entity.Vote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {

    int countByCat(Cat cat);
}
