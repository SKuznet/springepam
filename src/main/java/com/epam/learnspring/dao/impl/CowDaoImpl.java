package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.CowDao;
import com.epam.learnspring.entity.Cow;


public class CowDaoImpl extends BasicDaoImpl<Cow> implements CowDao {
    public CowDaoImpl(Class<Cow> entityClass) {
        super(entityClass);
    }
}