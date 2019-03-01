package com.epam.learnspring.controller;

import com.epam.learnspring.entity.*;
import com.epam.learnspring.service.impl.SuperHeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SuperHeroController {

    @Autowired
    SuperHeroServiceImpl heroServiceImpl;

    private final String ROOT = "/superheroes";

    @GetMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero getHeroeById(@PathVariable long id) {
        return heroServiceImpl.getById(id);
    }

    @GetMapping(value = ROOT + "/all", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SuperHero> getAllHeroes() {
        return heroServiceImpl.getAll();
    }

    @PostMapping(value = ROOT + "/add", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void saveHero(@RequestBody SuperHero hero) {
        heroServiceImpl.add(hero);
    }

    @DeleteMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteHero(@PathVariable long id) {
        heroServiceImpl.delete(id);
    }

    @PutMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateHero(@RequestBody SuperHero hero, @PathVariable long id) {
        hero.setId(id);
        heroServiceImpl.update(hero);
    }

    @PutMapping(value = ROOT + "/addpower", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addSuperPowers(@RequestBody long heroId, long  superpowerId) {
        return heroServiceImpl.addSuperPowers(heroId, superpowerId);
    }

    @PutMapping(value = ROOT + "/allies/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addAllies(@RequestBody long allyHeroId, @PathVariable long id) {
        return heroServiceImpl.addAllies(id, allyHeroId);
    }

    @PutMapping(value = ROOT + "/enemies/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addEnemies(@RequestBody long enemyVillainId, @PathVariable long id) {
        return heroServiceImpl.addEnemies(id, enemyVillainId);
    }

    @PutMapping(value = ROOT + "/universe/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addUniverse(@RequestBody long universeId, @PathVariable long id) {
        return heroServiceImpl.addUniverse(id, universeId);
    }

    @PutMapping(value = ROOT + "/alterego/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addAlterEgo(@RequestBody long personId, @PathVariable long id) {
        return heroServiceImpl.addAlterEgo(id, personId);
    }

}
