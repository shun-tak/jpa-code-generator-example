package com.github.shuntak.generator.example.hello.entity.dao.ext;

import com.github.shuntak.generator.example.hello.entity.dao.ext.impl.UserDaoImpl;
import com.github.shuntak.generator.example.hello.entity.ext.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {
    private static EntityManager entityManager;
    private static UserDao userDao;

    @BeforeClass
    public static void initialize() {
        Map<String, String> properties = new HashMap<String, String>() {
            {put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");}
            {put("hibernate.connection.url", "jdbc:mysql://localhost/example");}
            {put("hibernate.connection.username", "root");}
            {put("hibernate.connection.password", "");}
            {put("hibernate.show_sql", "true");}
            {put("hibernate.format_sql", "true");}
        };
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("example", properties);

        entityManager = entityManagerFactory.createEntityManager();
        userDao = new UserDaoImpl(entityManager);
    }

    @Before
    public void startTransaction() {
        entityManager.getTransaction().begin();
    }

    @Test
    public void createThenSelect() {
        User created = userDao.create("test");
        assertThat(created.getId()).isNotNull();

        Optional<User> actual = userDao.find(created.getId());
        assertThat(actual.isPresent()).isTrue();
        actual.ifPresent(user -> {
            assertThat(user.getId()).isEqualTo(created.getId());
            assertThat(user.getName()).isEqualTo(created.getName());
            assertThat(user.getCreatedAt()).isNotNull();
            assertThat(user.getUpdatedAt()).isNotNull();
        });
    }

    @After
    public void rollback() {
        entityManager.getTransaction().rollback();
    }
}
