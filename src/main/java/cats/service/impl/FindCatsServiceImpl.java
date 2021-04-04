package cats.service.impl;

import cats.entity.Cat;
import cats.repository.storage.CatRepository;
import cats.service.FindCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindCatsServiceImpl implements FindCatService {

    @Autowired private CatRepository catRepository;

    @Value("${limit.cat}") private int limitCat;
    @Value("${limit.top.cat}") private int limitTopCat;

    @Override
    public List<Cat> findTwoCat(long accountId) {
        List<Cat> catIdList = catRepository.findTwoCat(accountId, limitCat);
        if (catIdList.size() < limitCat) return Collections.emptyList();
        return catIdList;
    }

    @Override
    public List<Cat> findTopCat() {
        return catRepository.findTopCats(limitTopCat);
    }

    @Override
    public void addCat(Cat cat) {
        catRepository.save(cat);
    }
}
