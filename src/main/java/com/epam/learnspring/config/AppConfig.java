package com.epam.learnspring.config;

import com.epam.learnspring.dao.*;
import com.epam.learnspring.dao.impl.*;
import com.epam.learnspring.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:ioc.xml")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public CatDao catDao() {
        return new CatDaoImpl(Cat.class);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }

    @Bean
    public UniverseDao universeDao() {
        return new UniverseDaoImpl(Universe.class);
    }

    @Bean
    public PersonDao personDao() {
        return new PersonDaoImpl(Person.class);
    }

    @Bean
    public SuperPowerDao superPowerDao() {
        return new SuperPowerDaoImpl(SuperPower.class);
    }

    @Bean
    public SuperHeroDao superHeroDao() {
        return new SuperHeroDaoImpl(SuperHero.class);
    }

    @Bean
    public SuperVillainDao superVillainDao() {
        return new SuperVillainDaoImpl(SuperVillain.class);
    }


}
