package com.epam.learnspring.service.impl;

import com.epam.learnspring.service.WardenService;
import org.springframework.stereotype.Service;

@Service
public class WardenServiceImpl implements WardenService {

    @Override
    public String getAchievement(String value) {
        return "I slave " + value + "!";
    }

    public String getSong(String value) {
        return value;
    }
}
