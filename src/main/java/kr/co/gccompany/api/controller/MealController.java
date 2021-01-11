package kr.co.gccompany.api.controller;

import java.time.LocalDateTime;
import kr.co.gccompany.api.entity.MealComment;
import kr.co.gccompany.api.entity.MealLike;
import kr.co.gccompany.api.repository.CommentRepository;
import kr.co.gccompany.api.repository.MealLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {

  private final CommentRepository commentRepository;

  private final MealLikeRepository mealLikeRepository;

  @GetMapping("/{mealId}/comments/count")
  public Mono<Integer> countComments(@PathVariable("mealId") Integer mealId) {
    return commentRepository.countAllByMealId(mealId);
  }

  @PostMapping("/{mealId}/comment")
  public Mono<MealComment> createComment(
      @PathVariable("mealId") Integer mealId, @RequestBody MealComment comment) {

    comment.setMealId(mealId);
    comment.setCreatedAt(LocalDateTime.now());
    return commentRepository.save(comment);
  }

  @GetMapping("/{mealId}/comments")
  public Flux<MealComment> getComments(@PathVariable("mealId") Integer mealId) {
    return commentRepository.findAllByMealIdOrderByCreatedAtDesc(mealId);
  }

  @PostMapping("/{mealId}/like")
  public Mono<MealLike> createLike(
      @PathVariable("mealId") Integer mealId, @RequestBody MealLike mealLike) {

    mealLike.setMealId(mealId);
    mealLike.setCreatedAt(LocalDateTime.now());
    return mealLikeRepository.save(mealLike);
  }

  @GetMapping("/{mealId}/likes/count")
  public Mono<Integer> countLikes(@PathVariable("mealId") Integer mealId) {
    return mealLikeRepository.countAllByMealId(mealId);
  }
}
