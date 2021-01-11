package kr.co.gccompany.api.repository;

import kr.co.gccompany.api.entity.MealComment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CommentRepository extends ReactiveCrudRepository<MealComment, Integer> {

  Mono<Integer> countAllByMealId(Integer mealId);

  Flux<MealComment> findAllByMealIdOrderByCreatedAtDesc(Integer mealId);
}
