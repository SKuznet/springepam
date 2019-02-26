package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.SuperHeroDao;
import com.epam.learnspring.entity.SuperHero;

public class SuperHeroDaoImpl extends BasicDaoImpl<SuperHero> implements SuperHeroDao {
    public SuperHeroDaoImpl(Class<SuperHero> entityClass) {
        super(entityClass);
    }
}
