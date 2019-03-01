package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.DoorDao;
import com.epam.learnspring.dao.FilmDao;
import com.epam.learnspring.entity.Door;
import com.epam.learnspring.entity.Film;
import com.epam.learnspring.service.DoorService;
import com.epam.learnspring.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("doorService")
public class DoorServiceImpl implements DoorService {
    private final DoorDao doorDao;

    @Autowired
    public DoorServiceImpl(DoorDao doorDao) {
        this.doorDao = doorDao;
    }

    @Override
    public Door add(Door door) {
        return doorDao.add(door);
    }

    @Override
    public Door update(Door door) {
        return doorDao.update(door);
    }

    @Override
    public Door delete(long id) {
        return doorDao.delete(doorDao.getById(id));
    }

    @Override
    public Door getById(long id) {
        return doorDao.getById(id);
    }

    @Override
    public List<Door> getAll() {
        return doorDao.getAll();
    }
}
