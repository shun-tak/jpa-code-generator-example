package com.github.shuntak.generator.example.hello.entity.ext;

import com.github.shuntak.generator.example.hello.entity.AbstractUser;
import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractUser {
    @Builder
    public User(Long id, String name) {
        super(id, name);
    }
}
