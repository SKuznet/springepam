package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.RockerDao;
import com.epam.learnspring.entity.Rocker;

public class RockerDaoImpl extends BasicDaoImpl<Rocker> implements RockerDao {
    public RockerDaoImpl(Class<Rocker> entityClass) {
        super(entityClass);
    }
}
