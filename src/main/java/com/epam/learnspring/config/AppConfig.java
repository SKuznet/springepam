package com.epam.springlesson2.config;

import com.epam.springlesson2.dao.CowDao;
import com.epam.springlesson2.dao.impl.CowDaoImpl;
import com.epam.springlesson2.entity.Cow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CowDao cowDao() {
        return new CowDaoImpl(Cow.class);
    }
}