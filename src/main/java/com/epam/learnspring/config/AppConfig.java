package com.epam.learnspring.config;

import com.epam.learnspring.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ImportResource("classpath:ioc.xml")
@EnableAspectJAutoProxy
public class AppConfig {
}
