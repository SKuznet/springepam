package com.epam.learnspring.config;

import com.epam.learnspring.dao.LionessDao;
import com.epam.learnspring.dao.impl.LionessDaoImpl;
import com.epam.learnspring.entity.Lioness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LionessConfig {
    @Bean
    public LionessDao getLionessDao() {
        return new LionessDaoImpl(Lioness.class);
    }
}