package com.github.shuntak.generator.example.hello.entity.dao;

import com.github.shuntak.generator.example.hello.entity.ext.User;
import org.joda.time.DateTime;

import java.util.List;

/**
 * User DAO base interface.
 * Auto generated by JPA code generator.
 */
@javax.annotation.Generated(value = "JPACodeGenerator")
public interface AbstractUserDao extends AbstractDao<User> {
    User create(String name);

    List<User> findAll();

    User findById(Long id);
}