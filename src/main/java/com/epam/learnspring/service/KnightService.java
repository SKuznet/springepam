package com.epam.learnspring.service;

import org.springframework.stereotype.Service;

@Service
public class KnightService {

    public String getAchievement(String value) {
        return "I've slayed a " + value + "!";
    }
}
