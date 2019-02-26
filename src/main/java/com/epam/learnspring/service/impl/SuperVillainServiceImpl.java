package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.SuperVillainDao;
import com.epam.learnspring.entity.*;
import com.epam.learnspring.service.SuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperVillainServiceImpl implements SuperVillainService {

    SuperVillainDao villainDao;

    @Autowired
    public SuperVillainServiceImpl(SuperVillainDao villainDao) {
        this.villainDao = villainDao;
    }

    @Override
    public SuperVillain add(SuperVillain superVillain) {
        return villainDao.add(superVillain);
    }

    @Override
    public SuperVillain update(SuperVillain superVillain) {
        return villainDao.update(superVillain);
    }

    @Override
    public SuperVillain delete(long id) {
        return villainDao.delete(getById(id));
    }

    @Override
    public SuperVillain getById(long id) {
        return villainDao.getById(id);
    }

    @Override
    public List<SuperVillain> getAll() {
        return villainDao.getAll();
    }

    public SuperVillain addSuperPowers(long id, List<SuperPower> superPower) {
        SuperVillain villain = villainDao.getById(id);
        villain.setSuperPowers(superPower);
        return villainDao.update(villain);
    }

    public SuperVillain addEnemies(long id, List<SuperHero> enemies) {
        SuperVillain villain = villainDao.getById(id);
        villain.setEnemies(enemies);
        return villainDao.update(villain);
    }

    public SuperVillain addAllies(long id, List<SuperVillain> allies) {
        SuperVillain villain = villainDao.getById(id);
        villain.setAllies(allies);
        return villainDao.update(villain);
    }

    public SuperVillain addUniverse(Long id, Universe universe) {
        SuperVillain villain = villainDao.getById(id);
        villain.setUniverse(universe);
        return villainDao.update(villain);
    }

    public SuperVillain addAlterEgo(Long id, Person person) {
        SuperVillain villain = villainDao.getById(id);
        villain.setAlterEgo(person);
        return villainDao.update(villain);
    }
}
