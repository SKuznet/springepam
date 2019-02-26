package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.UniverseDao;
import com.epam.learnspring.entity.Universe;

public class UniverseDaoImpl extends BasicDaoImpl<Universe> implements UniverseDao {

    public UniverseDaoImpl(Class<Universe> entityClass) {
        super(entityClass);
    }
}
