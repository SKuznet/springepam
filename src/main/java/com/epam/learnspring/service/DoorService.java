package com.epam.learnspring.service;

import com.epam.learnspring.entity.Door;

import java.util.List;

public interface DoorService {

    Door add(Door door);

    Door update(Door door);

    Door delete(long id);

    Door getById(long id);

    List<Door> getAll();
}
