package com.epam.learnspring.model.impl;

import com.epam.learnspring.service.HeroService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DemonHunterImpl implements HeroService {
    @Override
    public String getName() {
        return "Demon Hunter";
    }
}
