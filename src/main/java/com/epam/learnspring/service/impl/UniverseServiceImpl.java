package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.UniverseDao;
import com.epam.learnspring.entity.Universe;
import com.epam.learnspring.service.UniverseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UniverseServiceImpl implements UniverseService {

    private final UniverseDao universeDao;

    @Autowired
    public UniverseServiceImpl(UniverseDao universeDao) {
        this.universeDao = universeDao;
    }

    @Override
    public Universe add(Universe universe) {
        log.info("add universe");
        return universeDao.add(universe);
    }

    @Override
    public Universe update(Universe universe) {
        log.info("update universe");
        return universeDao.update(universe);
    }

    @Override
    public Universe delete(long id) {
        log.info("delete universe with id:" + id);
        return universeDao.delete(getById(id));
    }

    @Override
    public Universe getById(long id) {
        log.info("get universe with id:" + id);
        return universeDao.getById(id);
    }

    public List<Universe> getAll() {
        log.info("get all universes");
        return universeDao.getAll();
    }
}
