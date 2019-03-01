package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.DoorDao;
import com.epam.learnspring.entity.Door;

public class DoorDaoImpl extends BasicDaoImpl<Door> implements DoorDao {
    public DoorDaoImpl(Class<Door> entityClass) {
        super(entityClass);
    }

}
