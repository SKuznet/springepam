package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.RoomDao;
import com.epam.learnspring.entity.Door;
import com.epam.learnspring.entity.Room;
import com.epam.learnspring.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public Room add(Room room) {
        return roomDao.add(room);
    }

    @Override
    public Room update(Room room) {
        return roomDao.update(room);
    }

    @Override
    public Room delete(long id) {
        return roomDao.delete(roomDao.getById(id));
    }

    @Override
    public Room getById(long id) {
        return roomDao.getById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }
}
