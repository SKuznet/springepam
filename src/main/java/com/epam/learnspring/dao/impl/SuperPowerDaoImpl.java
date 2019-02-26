package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.SuperPowerDao;
import com.epam.learnspring.entity.SuperPower;

public class SuperPowerDaoImpl extends BasicDaoImpl<SuperPower> implements SuperPowerDao {

    public SuperPowerDaoImpl(Class<SuperPower> entityClass) {
        super(entityClass);
    }
}
