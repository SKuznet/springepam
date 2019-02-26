package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.UniverseDao;
import com.epam.learnspring.entity.Universe;
import com.epam.learnspring.service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniverseServiceImpl implements UniverseService {

    private final UniverseDao universeDao;

    @Autowired
    public UniverseServiceImpl(UniverseDao universeDao) {
        this.universeDao = universeDao;
    }

    @Override
    public Universe add(Universe universe) {
        return universeDao.add(universe);
    }

    @Override
    public Universe update(Universe universe) {
        return universeDao.update(universe);
    }

    @Override
    public Universe delete(long id) {
        return universeDao.delete(getById(id));
    }

    @Override
    public Universe getById(long id) {
        return universeDao.getById(id);
    }

    public List<Universe> getAll() {
        return universeDao.getAll();
    }
}
