package kr.co.gccompany.api.controller;

import java.time.LocalDateTime;
import kr.co.gccompany.api.entity.MealComment;
import kr.co.gccompany.api.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentRepository commentRepository;

  @GetMapping("")
  public Flux<MealComment> all() {
    return commentRepository.findAll();
  }

  @PostMapping("")
  public Mono<MealComment> create(@RequestBody MealComment mealComment) {
    mealComment.setCreatedAt(LocalDateTime.now());
    return commentRepository.save(mealComment);
  }

  @PutMapping("/{id}")
  public Mono<MealComment> update(@PathVariable("id") Integer id, @RequestBody MealComment mealComment) {
    return commentRepository
        .findById(id)
        .map(
            c -> {
              c.setNickName(mealComment.getNickName());
              c.setComment(mealComment.getComment());
              return c;
            })
        .flatMap(c -> commentRepository.save(c));
  }

  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") Integer id) {
    return commentRepository.deleteById(id);
  }

  @GetMapping("/{mealId}/count")
  public Mono<Integer> count(@PathVariable("mealId") Integer mealId){
    return commentRepository.countAllByMealId(mealId);
  }
}
