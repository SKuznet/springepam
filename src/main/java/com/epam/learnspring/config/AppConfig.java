package com.epam.learnspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:ioc.xml")
@EnableAspectJAutoProxy
public class AppConfig {


}
