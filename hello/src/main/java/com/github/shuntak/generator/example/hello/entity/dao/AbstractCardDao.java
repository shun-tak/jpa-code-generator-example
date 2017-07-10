package com.github.shuntak.generator.example.hello.entity.dao;

import com.github.shuntak.generator.example.hello.entity.AbstractCard;
import com.github.shuntak.generator.example.hello.entity.ext.Card;

import javax.annotation.Generated;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Card DAO base interface.
 * Auto generated by JPA code generator.
 */
@Generated(value = "JPACodeGenerator")
public interface AbstractCardDao extends AbstractDao<Card> {
    Card persist(Integer id, String name, Integer rarity);

    List<Card> findAll();

    Optional<Card> find(Integer id);
}
