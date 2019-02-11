package com.epam.learnspring.service.impl;

import com.epam.learnspring.service.KnightService;
import org.springframework.stereotype.Service;

@Service
public class KnightServiceImpl implements KnightService {

    @Override
    public String getAchievement(String val) {
        return "I slave a " + val + "!";
    }
}
