package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.LionessDao;
import com.epam.learnspring.entity.Lioness;

public class LionessDaoImpl extends BasicDaoImpl<Lioness> implements LionessDao {
    public LionessDaoImpl(Class<Lioness> entityClass) {
        super(entityClass);
    }
}