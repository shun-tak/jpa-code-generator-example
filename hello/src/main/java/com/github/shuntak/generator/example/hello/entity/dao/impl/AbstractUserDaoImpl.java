package com.github.shuntak.generator.example.hello.entity.dao.impl;

import com.github.shuntak.generator.example.hello.entity.dao.AbstractUserDao;
import com.github.shuntak.generator.example.hello.entity.ext.User;
import com.github.shuntak.generator.example.hello.entity.ext.User_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.joda.time.DateTime;

import java.util.List;

/**
 * User DAO base class.
 * Auto generated by JPA code generator.
 */
@javax.annotation.Generated(value = "JPACodeGenerator")
public abstract class AbstractUserDaoImpl extends AbstractDaoImpl<User> implements AbstractUserDao {
    protected AbstractUserDaoImpl(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    public User create(String name) {
        User user = User
                .builder()
                .name(name)
                .build();
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(user);
        getEntityManager().getTransaction().commit();
        return user;
    }

    public List<User> findAll() {
        CriteriaQuery<User> query = criteriaQuery();
        Root<User> root = query.from(getEntityClass());
        query.select(root);
        return list(query);
    }

    public User findById(Long id) {
        CriteriaQuery<User> query = criteriaQuery();
        Root<User> root = query.from(getEntityClass());
        query.select(root)
                .where(criteriaBuilder().equal(root.get(User_.id), id));
        return uniqueResult(query);
    }
}