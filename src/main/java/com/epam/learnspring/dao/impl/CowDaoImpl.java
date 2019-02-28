package com.epam.springlesson2.dao.impl;

import com.epam.springlesson2.dao.CowDao;
import com.epam.springlesson2.entity.Cow;


public class CowDaoImpl extends BasicDaoImpl<Cow> implements CowDao {
    public CowDaoImpl(Class<Cow> entityClass) {
        super(entityClass);
    }
}