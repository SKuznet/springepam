package com.epam.learnspring.model.impl;

import com.epam.learnspring.service.DogService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service("secondDog")
public class SecondDogImpl implements DogService {
    @Bean
    @Override
    public String getBark() {
        return "arrrrrWOW!";
    }

    @Override
    public String getName() {
        return "Second Dog name!";
    }
}
