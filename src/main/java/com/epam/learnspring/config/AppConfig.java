package com.epam.learnspring.config;

import com.epam.learnspring.dao.EmployeeDao;
import com.epam.learnspring.dao.FilmDao;
import com.epam.learnspring.dao.impl.EmployeeDaoImpl;
import com.epam.learnspring.dao.impl.FilmDaoImpl;
import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.entity.Film;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ImportResource("classpath:ioc.xml")
@EnableSwagger2
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }

    @Bean
    public FilmDao filmDao() {
        return new FilmDaoImpl(Film.class);
    }

}
