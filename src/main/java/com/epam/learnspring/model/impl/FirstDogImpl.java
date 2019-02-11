package com.epam.learnspring.model.impl;

import com.epam.learnspring.service.DogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("firstDog")
@Primary
public class FirstDogImpl implements DogService {
    @Bean
    @Override
    public String getBark() {
        return "Baw-Waw";
    }

    @Override
    public String getName() {
        return "First Dog name!";
    }
}
