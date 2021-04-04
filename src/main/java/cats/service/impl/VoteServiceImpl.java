package cats.service.impl;

import cats.entity.Cat;
import cats.entity.Profile;
import cats.entity.Vote;
import cats.repository.storage.CatRepository;
import cats.repository.storage.VoteRepository;
import cats.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired private VoteRepository voteRepository;
    @Autowired private CatRepository catRepository;

    @Transactional
    @Override
    public void vote(Profile profile, long catId, boolean vote) {
        Vote profileVote = new Vote();
        profileVote.setProfile(profile);
        profileVote.setCat(catRepository.findById(catId));
        profileVote.setVote(vote);
        voteRepository.save(profileVote);
    }

    @Override
    public int getCountVoteByCat(Cat cat) {
        return voteRepository.countByCat(cat);
    }
}
