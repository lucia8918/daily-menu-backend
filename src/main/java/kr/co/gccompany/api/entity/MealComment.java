package kr.co.gccompany.api.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("Comment")
public class MealComment {

  @Id private Integer id;

  @Column("mealId")
  private Integer mealId;

  @Column("nickName")
  private String nickName;

  private String comment;

  @Column("createdAt")
  private LocalDateTime createdAt;
}
