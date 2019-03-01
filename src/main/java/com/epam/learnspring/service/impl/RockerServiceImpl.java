package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.RockerDao;
import com.epam.learnspring.dto.RockerDto;
import com.epam.learnspring.entity.Rocker;
import com.epam.learnspring.service.RockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class RockerServiceImpl implements RockerService {
    private final RockerDao rockerDao;
    private final RockerDto rockerDto;

    @Autowired
    public RockerServiceImpl(RockerDao rockerDao, RockerDto rockerDto) {
        this.rockerDao = rockerDao;
        this.rockerDto = rockerDto;
    }

    @Override
    public Rocker add(Rocker rocker) {
        return rockerDao.add(rocker);
    }

    @Override
    public Rocker update(Rocker rocker) {
        return rockerDao.update(rocker);
    }

    @Override
    public Rocker delete(long id) {
        return rockerDao.delete(rockerDao.getById(id));
    }

    @Override
    public RockerDto getById(long id) {
        return rockerDto.getRockerDtoFromRocker(rockerDao.getById(id));
    }

    @Override
    public List<Rocker> getAllRockers() {
        return rockerDao.getAll();
    }
}
