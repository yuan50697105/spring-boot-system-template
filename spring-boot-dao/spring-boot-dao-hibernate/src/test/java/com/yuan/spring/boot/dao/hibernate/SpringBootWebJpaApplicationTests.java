package com.yuan.spring.boot.dao.hibernate;

import com.yuan.spring.boot.dao.hibernate.dao.impl.HibernateDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass = HibernateDaoImpl.class)
public class SpringBootWebJpaApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }
}