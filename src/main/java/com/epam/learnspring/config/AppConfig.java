package com.epam.learnspring.config;

import com.epam.learnspring.dao.CategoryDao;
import com.epam.learnspring.dao.FilmDao;
import com.epam.learnspring.dao.impl.CategoryDaoImpl;
import com.epam.learnspring.dao.impl.FilmDaoImpl;
import com.epam.learnspring.entity.Category;
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
    public FilmDao filmDao() {
        return new FilmDaoImpl(Film.class);
    }

    @Bean
    public CategoryDao categoryDao() {
        return new CategoryDaoImpl(Category.class);
    }

}
