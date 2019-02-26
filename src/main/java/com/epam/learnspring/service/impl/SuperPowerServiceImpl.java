package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.SuperPowerDao;
import com.epam.learnspring.entity.SuperPower;
import com.epam.learnspring.service.SuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperPowerServiceImpl implements SuperPowerService {

    private final SuperPowerDao superPowerDao;

    @Autowired
    public SuperPowerServiceImpl(SuperPowerDao superPowerDao) {
        this.superPowerDao = superPowerDao;
    }

    @Override
    public SuperPower add(SuperPower superPower) {
        return superPowerDao.add(superPower);
    }

    @Override
    public SuperPower update(SuperPower superPower) {
        return superPowerDao.update(superPower);
    }

    @Override
    public SuperPower delete(long id) {
        return superPowerDao.delete(getById(id));
    }

    @Override
    public SuperPower getById(long id) {
        return superPowerDao.getById(id);
    }

    @Override
    public List<SuperPower> getAll() {
        return superPowerDao.getAll();
    }
}
