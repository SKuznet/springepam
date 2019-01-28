package com.epam.learnspring.model.impl;

import com.epam.learnspring.model.CatService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MurzikCatImpl implements CatService {
    @Override
    public String getName() {
        return "Murzik";
    }
}
