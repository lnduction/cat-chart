package cats.service;

import cats.entity.Cat;

import java.util.List;

public interface FindCatService {

    List<Cat> findTwoCat(long accountId);
    List<Cat> findTopCat();
    void addCat(Cat cat);
}
