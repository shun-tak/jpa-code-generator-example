package com.github.shuntak.generator.example.hello.entity.dao.ext;

import com.github.shuntak.generator.example.hello.entity.dao.ext.impl.UserDaoImpl;
import com.github.shuntak.generator.example.hello.entity.ext.User;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {
    static UserDaoImpl userDao;

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
                Persistence.createEntityManagerFactory("hello-entity", properties);

        userDao = new UserDaoImpl(entityManagerFactory.createEntityManager());
    }

    @Test
    public void SelectById() {
        User created = userDao.create("test");
        assertThat(created.getId()).isNotNull();

        User actual = userDao.findById(created.getId());
        assertThat(actual.getId()).isEqualTo(created.getId());
    }
}
