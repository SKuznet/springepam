package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.SuperPowerDao;
import com.epam.learnspring.entity.SuperPower;
import com.epam.learnspring.service.SuperPowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SuperPowerServiceImpl implements SuperPowerService {

    private final SuperPowerDao superPowerDao;

    @Autowired
    public SuperPowerServiceImpl(SuperPowerDao superPowerDao) {
        this.superPowerDao = superPowerDao;
    }

    @Override
    public SuperPower add(SuperPower superPower) {
        log.info("add superpower");
        return superPowerDao.add(superPower);
    }

    @Override
    public SuperPower update(SuperPower superPower) {
        log.info("update superpower");
        return superPowerDao.update(superPower);
    }

    @Override
    public SuperPower delete(long id) {
        log.info("delete superpower with id: " + id);
        return superPowerDao.delete(getById(id));
    }

    @Override
    public SuperPower getById(long id) {
        log.info("get superpower with id: " + id);
        return superPowerDao.getById(id);
    }

    @Override
    public List<SuperPower> getAll() {
        log.info("get all superpowers");
        return superPowerDao.getAll();
    }
}
