package cats.repository.storage;


import cats.entity.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatRepository extends PagingAndSortingRepository<Cat, Long> {

    @Query(value = "select * from cat where cat.id not in (select distinct(vote.cat_id) from vote where vote.profile_id =?1) order by random() limit ?2", nativeQuery = true)
    List<Cat> findTwoCat(long profileId, int limit);

    @Query(value = "select cat.id, cat.name, cat.photo from cat inner join (select count(distinct vote.profile_id) as cat_count, vote.cat_id from vote where vote.vote = true group by vote.cat_id) as count_top on cat.id = count_top.cat_id order by count_top.cat_count desc limit ?1", nativeQuery = true)
    List<Cat> findTopCats(int countTopCats);

    Cat findById(long id);


}
