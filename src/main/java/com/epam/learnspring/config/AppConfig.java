package com.epam.learnspring.config;

import com.epam.learnspring.dao.HumanDao;
import com.epam.learnspring.dao.RockerDao;
import com.epam.learnspring.dao.impl.HumanDaoImpl;
import com.epam.learnspring.dao.impl.RockerDaoImpl;
import com.epam.learnspring.entity.Human;
import com.epam.learnspring.entity.Rocker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:ioc.xml")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public HumanDao humanDao() {
        return new HumanDaoImpl(Human.class);
    }

    @Bean
    public RockerDao employeeDao() {
        return new RockerDaoImpl(Rocker.class);
    }

}
