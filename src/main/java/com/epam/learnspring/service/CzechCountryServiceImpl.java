package com.epam.learnspring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CzechCountryServiceImpl implements CountryService {
    @Override
    public String getLanguage() {
        return "Czech";
    }
}
