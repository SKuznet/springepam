package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.CatDao;
import com.epam.learnspring.entity.Cat;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {
    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }
}
