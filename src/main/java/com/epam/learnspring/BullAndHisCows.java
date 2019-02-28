package com.epam.springlesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BullAndHisCows {
    public static void main(String[] args) {
        SpringApplication.run(BullAndHisCows.class, args);
    }
}