package com.epam.learnspring.config;

import com.epam.learnspring.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = "util.properties")
@PropertySource(value = "auth.properties")
public class DataConfig {

    @Bean
    public DriverManagerDataSource dataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getProperty("usersByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getProperty("rolesByQuery"));
        return jdbcDao;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    private Environment environment;

    public Environment getEnvironment() {
        return environment;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public CreateTable createTable() {
        return new CreateTable(jdbcTemplate());
    }

}
