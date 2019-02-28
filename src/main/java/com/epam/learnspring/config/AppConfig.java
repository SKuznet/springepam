package com.epam.learnspring.config;

import com.epam.learnspring.dao.CowDao;
import com.epam.learnspring.dao.impl.CowDaoImpl;
import com.epam.learnspring.entity.Cow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CowDao cowDao() {
        return new CowDaoImpl(Cow.class);
    }
}