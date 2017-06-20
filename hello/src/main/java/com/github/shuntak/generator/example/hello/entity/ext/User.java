package com.github.shuntak.generator.example.hello.entity.ext;

import com.github.shuntak.generator.example.hello.entity.AbstractUser;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractUser {
    @Builder
    public User(Long id, String name, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        super(id, name, createdAt, updatedAt);
    }
}
