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

    private final String tag = "/superheroes/";

    @GetMapping(tag + "{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperHero getHeroes(@PathVariable long id) {
        return heroServiceImpl.getById(id);
    }

    @GetMapping(tag)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SuperHero> getHeroById() {
        return heroServiceImpl.getAll();
    }

    @PostMapping(tag + "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveHero(@RequestBody SuperHero hero) {
        heroServiceImpl.add(hero);
    }

    @DeleteMapping(tag + "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteHero(@PathVariable long id) {
        heroServiceImpl.delete(id);
    }

    @PutMapping(tag + "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateHero(@RequestBody SuperHero hero, @PathVariable Long id) {
        hero.setId(id);
        heroServiceImpl.update(hero);
    }

    @PutMapping(tag + "superpowers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addSuperPowers(@RequestBody List<SuperPower> powers, @PathVariable Long id) {
        return heroServiceImpl.addSuperPowers(id, powers);
    }

    @PutMapping(tag + "allies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addAllies(@RequestBody List<SuperHero> allies, @PathVariable Long id) {
        return heroServiceImpl.addAllies(id, allies);
    }

    @PutMapping(tag + "enemies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addEnemies(@RequestBody List<SuperVillain> enemies, @PathVariable Long id) {
        return heroServiceImpl.addEnemies(id, enemies);
    }

    @PutMapping(tag + "universe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addUniverse(@RequestBody Universe universe, @PathVariable Long id) {
        return heroServiceImpl.addUniverse(id, universe);
    }

    @PutMapping(tag + "alterego/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperHero addAlterEgo(@RequestBody Person person, @PathVariable Long id) {
        return heroServiceImpl.addAlterEgo(id, person);
    }

}
