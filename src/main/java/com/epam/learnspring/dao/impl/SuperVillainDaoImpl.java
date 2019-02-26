package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.SuperVillainDao;
import com.epam.learnspring.entity.SuperVillain;

public class SuperVillainDaoImpl extends BasicDaoImpl<SuperVillain> implements SuperVillainDao {

    public SuperVillainDaoImpl(Class<SuperVillain> entityClass) {
        super(entityClass);
    }
}
