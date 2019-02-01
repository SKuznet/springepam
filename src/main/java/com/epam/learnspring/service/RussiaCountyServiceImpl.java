package com.epam.learnspring.service;

import org.springframework.stereotype.Service;

@Service
public class RussiaCountyServiceImpl implements CountryService{
    @Override
    public String getLanguage() {
        return "Russian";
    }
}
