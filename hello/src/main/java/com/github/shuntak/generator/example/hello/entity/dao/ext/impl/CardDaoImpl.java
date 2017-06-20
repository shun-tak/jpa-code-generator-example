package com.github.shuntak.generator.example.hello.entity.dao.ext.impl;

import com.github.shuntak.generator.example.hello.entity.dao.ext.CardDao;
import com.github.shuntak.generator.example.hello.entity.dao.impl.AbstractCardDaoImpl;

import javax.persistence.EntityManager;

public class CardDaoImpl extends AbstractCardDaoImpl implements CardDao {
    public CardDaoImpl() {
        super();
    }

    public CardDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
