package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.RoomDao;
import com.epam.learnspring.entity.Room;

public class RoomDaoImpl extends BasicDaoImpl<Room> implements RoomDao {
    public RoomDaoImpl(Class<Room> entityClass) {
        super(entityClass);
    }

}
