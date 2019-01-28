package com.epam.learnspring.model.impl;

import com.epam.learnspring.model.CatService;
import org.springframework.stereotype.Service;

@Service("barsikCat")
public class BarsikCatImpl implements CatService {

    @Override
    public String getName() {
        return "Barsik";
    }
}
