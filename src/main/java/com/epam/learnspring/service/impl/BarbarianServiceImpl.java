package com.epam.learnspring.service.impl;

import com.epam.learnspring.service.BarbarianService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbarianServiceImpl implements BarbarianService {
    private SessionFactory sessionFactory;

    @Override
    public String getAchievement(String val) {
        return "I slave a " + val + "!";
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
