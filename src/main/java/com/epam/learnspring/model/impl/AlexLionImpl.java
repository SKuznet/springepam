package com.epam.learnspring.model.impl;

import com.epam.learnspring.service.LionService;
import org.springframework.stereotype.Service;

@Service("alexLion")
public class AlexLionImpl implements LionService {
    @Override
    public String getName() {
        return "Alex";
    }
}
