package com.github.shuntak.generator.example.hello.entity.dao;

import com.github.shuntak.generator.example.hello.entity.AbstractUser;
import com.github.shuntak.generator.example.hello.entity.ext.user.User;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

/** User DAO base interface. Auto generated by JPA code generator. */
@Generated(value = "JPACodeGenerator")
public interface AbstractUserDao extends AbstractDao<User> {
  User persist(String name);

  Optional<User> find(Long id);

  List<User> findAll();
}
