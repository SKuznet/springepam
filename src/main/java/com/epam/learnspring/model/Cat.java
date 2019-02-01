package com.epam.learnspring.model;

import org.springframework.stereotype.Service;

@Service
public class Cat implements AnimalService {
    @Override
    public String getName() {
        return "Cat";
    }
}
