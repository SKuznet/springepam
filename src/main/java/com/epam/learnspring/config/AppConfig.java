package com.epam.learnspring.config;

import com.epam.learnspring.dao.*;
import com.epam.learnspring.dao.impl.*;
import com.epam.learnspring.entity.*;
import com.epam.learnspring.security.details.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:ioc.xml")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(User.class);
    }
    @Bean
    public UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl();
    }
    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }
    @Bean
    public EmployerDao employerDao() {
        return new EmployerDaoImpl(Employer.class);
    }

    @Bean
    public AuthorDao authorDao() {
        return new AuthorDaoImpl(Author.class);
    }

    @Bean
    public BookDao bookDao() {
        return new BookDaoImpl(Book.class);
    }
}
