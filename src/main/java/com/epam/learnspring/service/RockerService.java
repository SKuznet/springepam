package com.epam.learnspring.service;

import com.epam.learnspring.dto.RockerDto;
import com.epam.learnspring.entity.Rocker;

import java.util.List;

public interface RockerService {

    Rocker add(Rocker rocker);
    Rocker update(Rocker rocker);
    Rocker delete(long id);
    RockerDto getById(long id);
    List<Rocker> getAllRockers();
}
