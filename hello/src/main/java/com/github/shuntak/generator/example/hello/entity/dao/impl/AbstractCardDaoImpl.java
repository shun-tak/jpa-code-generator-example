package com.github.shuntak.generator.example.hello.entity.dao.impl;

import com.github.shuntak.generator.example.hello.entity.AbstractCard;
import com.github.shuntak.generator.example.hello.entity.dao.AbstractCardDao;
import com.github.shuntak.generator.example.hello.entity.ext.Card;
import com.github.shuntak.generator.example.hello.entity.ext.Card_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Card DAO base class.
 * Auto generated by JPA code generator.
 */
@javax.annotation.Generated(value = "JPACodeGenerator")
public abstract class AbstractCardDaoImpl extends AbstractDaoImpl<Card> implements AbstractCardDao {
    @PersistenceContext(unitName = "example_master")
    private EntityManager entityManager;

    protected AbstractCardDaoImpl() {
        super(Card.class);
    }

    protected AbstractCardDaoImpl(EntityManager entityManager) {
        super(Card.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public Card create(Card card) {
        getEntityManager().persist(card);
        getEntityManager().flush();
        return card;
    }

    @Override
    public Card create(Integer id, String name, Integer rarity) {
        Card card = Card
                .builder()
                .id(id)
                .name(name)
                .rarity(rarity)
                .build();
        return create(card);
    }

    @Override
    public List<Card> findAll() {
        CriteriaQuery<Card> query = criteriaQuery();
        Root<Card> root = query.from(getEntityClass());
        query.select(root);
        return list(query);
    }

    @Override
    public Optional<Card> find(Integer pk) {
        return Optional.ofNullable(getEntityManager().find(getEntityClass(), pk));
    }
}
