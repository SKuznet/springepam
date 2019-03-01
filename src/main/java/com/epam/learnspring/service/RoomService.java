package com.epam.learnspring.service;

import com.epam.learnspring.entity.Room;

import java.util.List;

public interface RoomService {

    Room add(Room room);

    Room update(Room room);

    Room delete(long id);

    Room getById(long id);

    List<Room> getAll();
}
