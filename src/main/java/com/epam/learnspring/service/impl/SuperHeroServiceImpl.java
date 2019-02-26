package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.PersonDao;
import com.epam.learnspring.dao.SuperHeroDao;
import com.epam.learnspring.dao.UniverseDao;
import com.epam.learnspring.entity.*;
import com.epam.learnspring.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    private final SuperHeroDao heroDao;

    private final UniverseDao universeDao;

    private final PersonDao personDao;

    @Autowired
    public SuperHeroServiceImpl(SuperHeroDao heroDao, UniverseDao universeDao, PersonDao personDao) {
        this.heroDao = heroDao;
        this.universeDao = universeDao;
        this.personDao = personDao;
    }

    @Override
    public SuperHero add(SuperHero hero) {
        return heroDao.add(hero);
    }

    @Override
    public SuperHero update(SuperHero hero) {
        return heroDao.update(hero);
    }

    @Override
    public SuperHero delete(long id) {
        return heroDao.delete(getById(id));
    }

    @Override
    public SuperHero getById(long id) {
        return heroDao.getById(id);
    }

    @Override
    public List<SuperHero> getAll() {
        return heroDao.getAll();
    }

    public SuperHero addSuperPowers(long id, List<SuperPower> superPower) {
        SuperHero hero = heroDao.getById(id);
        hero.setSuperPowers(superPower);
        return heroDao.update(hero);
    }

    public SuperHero addEnemies(long id, List<SuperVillain> enemies) {
        SuperHero hero = heroDao.getById(id);
        hero.setEnemies(enemies);
        return heroDao.update(hero);
    }

    public SuperHero addAllies(long id, List<SuperHero> allies) {
        SuperHero hero = heroDao.getById(id);
        hero.setAllies(allies);
        return heroDao.update(hero);
    }

    public SuperHero addUniverse(Long id, Universe universe) {
        SuperHero hero = heroDao.getById(id);
        hero.setUniverse(universe);
        return heroDao.update(hero);
    }

    public SuperHero addAlterEgo(Long id, Person person) {
        SuperHero hero = heroDao.getById(id);
        hero.setAlterEgo(person);
        return heroDao.update(hero);
    }
}
