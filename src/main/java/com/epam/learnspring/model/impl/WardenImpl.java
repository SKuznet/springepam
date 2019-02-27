package com.epam.learnspring.model.impl;

import com.epam.learnspring.model.HeroService;
import org.springframework.stereotype.Service;

@Service("warden")
public class WardenImpl implements HeroService {

    @Override
    public String getName() {
        return "Warden";
    }
}
