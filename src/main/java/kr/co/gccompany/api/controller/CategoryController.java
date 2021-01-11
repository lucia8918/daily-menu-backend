package kr.co.gccompany.api.controller;

import kr.co.gccompany.api.entity.Category;
import kr.co.gccompany.api.repository.CategoryRepository;
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
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryRepository categoryRepository;

  @GetMapping("")
  public Flux<Category> all() {
    return categoryRepository.findAll();
  }

  @PostMapping("")
  public Mono<Category> create(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @PutMapping("/{id}")
  public Mono<Category> update(@PathVariable("id") Integer id, @RequestBody Category category) {
    return categoryRepository
        .findById(id)
        .map(
            c -> {
              c.setName(category.getName());
              return c;
            })
        .flatMap(p -> categoryRepository.save(p));
  }

  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") Integer id) {
    return categoryRepository.deleteById(id);
  }
}
