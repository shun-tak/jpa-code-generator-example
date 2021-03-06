package com.github.shuntak.generator.example.hello.entity.ext.user;

import com.github.shuntak.generator.example.hello.entity.AbstractUser;
import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractUser {
  @Builder
  public User(
      Long id,
      String name,
      ZonedDateTime createdAt,
      ZonedDateTime updatedAt) {
    super(id, name, createdAt, updatedAt);
  }
}
