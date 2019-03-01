package com.epam.learnspring.config;

import com.epam.learnspring.dao.LaboratoryDao;
import com.epam.learnspring.dao.UserDao;
import com.epam.learnspring.dao.impl.LaboratoryDaoImpl;
import com.epam.learnspring.dao.impl.UserDaoImpl;
import com.epam.learnspring.entity.Laboratory;
import com.epam.learnspring.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(User.class);
    }

    @Bean
    public LaboratoryDao laboratoryDao() {
        return new LaboratoryDaoImpl(Laboratory.class);
    }
}
