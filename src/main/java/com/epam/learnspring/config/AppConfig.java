package com.epam.learnspring.config;

import com.epam.learnspring.dao.EmployeeDao;
import com.epam.learnspring.dao.EmployerDao;
import com.epam.learnspring.dao.UserDao;
import com.epam.learnspring.dao.impl.EmployeeDaoImpl;
import com.epam.learnspring.dao.impl.EmployerDaoImpl;
import com.epam.learnspring.dao.impl.UserDaoImpl;
import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.entity.User;
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

}
