package com.github.shuntak.generator.example.hello.entity.dao.ext.impl;

import com.github.shuntak.generator.example.hello.entity.dao.ext.UserDao;
import com.github.shuntak.generator.example.hello.entity.dao.impl.AbstractUserDaoImpl;

import javax.persistence.EntityManager;

public class UserDaoImpl extends AbstractUserDaoImpl implements UserDao {
    public UserDaoImpl() {
        super();
    }

    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
