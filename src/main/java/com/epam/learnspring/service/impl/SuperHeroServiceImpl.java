package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.*;
import com.epam.learnspring.entity.*;
import com.epam.learnspring.service.SuperHeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SuperHeroServiceImpl implements SuperHeroService {

    private final SuperHeroDao heroDao;

    private final SuperVillainDao villainDao;

    private final SuperPowerDao powerDao;

    private final UniverseDao universeDao;

    private final PersonDao personDao;

    @Autowired
    public SuperHeroServiceImpl(SuperHeroDao heroDao,
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
    public SuperHero add(SuperHero hero) {
        log.info("add Superhero");
        return heroDao.add(hero);
    }

    @Override
    public SuperHero update(SuperHero hero) {
        log.info("update Superhero");
        return heroDao.update(hero);
    }

    @Override
    public SuperHero delete(long id) {
        log.info("delete Superhero with id:" + id);
        return heroDao.delete(getById(id));
    }

    @Override
    public SuperHero getById(long id) {
        log.info("get Superhero with id:" + id);
        return heroDao.getById(id);
    }

    @Override
    public List<SuperHero> getAll() {
        log.info("get all Superheroes");
        return heroDao.getAll();
    }

    public SuperHero addSuperPowers(Long id, long superPowerId) {
        log.info("add superpower to superhero");
        SuperHero hero = heroDao.getById(id);
        hero.getSuperPowers().add(powerDao.getById(superPowerId));
        return heroDao.update(hero);
    }

    public SuperHero addEnemies(Long id, long villainId) {
        log.info("add enemy to superhero");
        SuperHero hero = heroDao.getById(id);
        hero.getEnemies().add(villainDao.getById(villainId));
        return heroDao.update(hero);
    }

    public SuperHero addAllies(Long id, long allyHeroId) {
        log.info("add ally to superhero");
        SuperHero hero = heroDao.getById(id);
        hero.getAllies().add(heroDao.getById(allyHeroId));
        return heroDao.update(hero);
    }

    public SuperHero addUniverse(Long id, long universeId) {
        log.info("add universe to superhero");
        SuperHero hero = heroDao.getById(id);
        hero.setUniverse(universeDao.getById(universeId));
        return heroDao.update(hero);
    }

    public SuperHero addAlterEgo(Long id, long personId) {
        log.info("add alter ego to superhero");
        SuperHero hero = heroDao.getById(id);
        hero.setAlterEgo(personDao.getById(personId));
        return heroDao.update(hero);
    }
}
