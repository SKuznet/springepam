package com.epam.learnspring.config;

import com.epam.learnspring.dao.CatDao;
import com.epam.learnspring.dao.impl.CatDaoImpl;
import com.epam.learnspring.entity.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:ioc.xml")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public CatDao catDao() {
        return new CatDaoImpl(Cat.class);
    }

}
