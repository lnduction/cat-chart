package cats.service;

import cats.entity.Cat;
import cats.entity.Profile;

public interface VoteService {
    void vote(Profile profile, long catId, boolean vote);
    int getCountVoteByCat(Cat cat);
}
