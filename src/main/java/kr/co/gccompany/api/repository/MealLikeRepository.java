package kr.co.gccompany.api.repository;

import kr.co.gccompany.api.entity.MealLike;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MealLikeRepository extends ReactiveCrudRepository<MealLike, Integer> {

  Mono<Integer> countAllByMealId(Integer mealId);
}
