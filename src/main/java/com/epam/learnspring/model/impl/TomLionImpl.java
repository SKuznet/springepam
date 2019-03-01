package com.epam.learnspring.model.impl;

import com.epam.learnspring.service.LionService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TomLionImpl implements LionService {
    @Override
    public String getName() {
        return "Tom";
    }
}