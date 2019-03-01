package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.*;
import com.epam.learnspring.entity.*;
import com.epam.learnspring.service.SuperVillainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SuperVillainServiceImpl implements SuperVillainService {

    private final SuperHeroDao heroDao;

    private final SuperVillainDao villainDao;

    private final SuperPowerDao powerDao;

    private final UniverseDao universeDao;

    private final PersonDao personDao;

    @Autowired
    public SuperVillainServiceImpl(
    SuperHeroDao heroDao,
    UniverseDao universeDao,
    PersonDao personDao,
    SuperVillainDao villainDao,
    SuperPowerDao powerDao) {
        this.heroDao = heroDao;
        this.universeDao = universeDao;
        this.personDao = personDao;
        this.villainDao = villainDao;
        this.powerDao = powerDao;
    }

    @Override
    public SuperVillain add(SuperVillain superVillain) {
        log.info("add super villain");
        return villainDao.add(superVillain);
    }

    @Override
    public SuperVillain update(SuperVillain superVillain) {
        log.info("update super villain");
        return villainDao.update(superVillain);
    }

    @Override
    public SuperVillain delete(long id) {
        log.info("delete super villain with id: " + id);
        return villainDao.delete(getById(id));
    }

    @Override
    public SuperVillain getById(long id) {
        log.info("get super villain with id: " + id);
        return villainDao.getById(id);
    }

    @Override
    public List<SuperVillain> getAll() {
        log.info("get all super villain");
        return villainDao.getAll();
    }

    public SuperVillain addSuperPowers(long id, Long powerId) {
        log.info("add super power to super villain");
        SuperVillain villain = villainDao.getById(id);
        villain.getSuperPowers().add(powerDao.getById(powerId));
        return villainDao.update(villain);
    }

    public SuperVillain addEnemies(long id, Long enemyHeroId) {
        log.info("add enemy to super villain");
        SuperVillain villain = villainDao.getById(id);
        villain.getEnemies().add(heroDao.getById(enemyHeroId));
        return villainDao.update(villain);
    }

    public SuperVillain addAllies(long id, Long allyVillainId) {
        log.info("add ally to super villain");
        SuperVillain villain = villainDao.getById(id);
        villain.getAllies().add(villainDao.getById(allyVillainId));
        return villainDao.update(villain);
    }

    public SuperVillain addUniverse(Long id, Universe universe) {
        log.info("add universe to super villain");
        SuperVillain villain = villainDao.getById(id);
        villain.setUniverse(universe);
        return villainDao.update(villain);
    }

    public SuperVillain addAlterEgo(Long id, Person person) {
        log.info("add alter ego to super villain");
        SuperVillain villain = villainDao.getById(id);
        villain.setAlterEgo(person);
        return villainDao.update(villain);
    }
}
