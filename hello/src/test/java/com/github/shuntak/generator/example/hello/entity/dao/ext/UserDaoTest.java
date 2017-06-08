package com.github.shuntak.generator.example.hello.entity.dao.ext;

import com.github.shuntak.generator.example.hello.entity.ext.User;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {
    static UserDao userDao;

    @BeforeClass
    public static void initialize() {
        Map<String, String> properties = new HashMap<String, String>() {
            {put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");}
            {put("hibernate.connection.url", "jdbc:mysql://localhost/example");}
            {put("hibernate.connection.username", "root");}
            {put("hibernate.connection.password", "");}
            {put("hibernate.show_sql", "true");}
            {put("hibernate.format_sql", "true");}
            {put("hbm2ddl.auto", "update");}
        };
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hello-entity", properties);

        userDao = new UserDao(entityManagerFactory.createEntityManager());
    }

    @Test
    public void SelectById() {
        userDao.create("test");
        User user = userDao.findById(1L);

        assertThat(user.getId()).isEqualTo(1L);
    }
}
