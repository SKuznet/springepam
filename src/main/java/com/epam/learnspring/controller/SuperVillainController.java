package com.epam.learnspring.controller;

import com.epam.learnspring.entity.*;
import com.epam.learnspring.service.impl.SuperHeroServiceImpl;
import com.epam.learnspring.service.impl.SuperVillainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SuperVillainController {

    @Autowired
    SuperVillainServiceImpl villainServiceImpl;

    private final String tag = "/supervillain/";

    @GetMapping(tag + "{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperVillain getVillain(@PathVariable long id) {
        return villainServiceImpl.getById(id);
    }

    @GetMapping(tag)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SuperVillain> getVillains() {
        return villainServiceImpl.getAll();
    }

    @PostMapping(tag + "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVillain(@RequestBody SuperVillain villain) {
        villainServiceImpl.add(villain);
    }

    @DeleteMapping(tag + "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVillain(@PathVariable long id) {
        villainServiceImpl.delete(id);
    }

    @PutMapping(tag + "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateVillain(@RequestBody SuperVillain villain, @PathVariable Long id) {
        villain.setId(id);
        villainServiceImpl.update(villain);
    }

    @PutMapping(tag + "superpowers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperVillain addSuperPowers(@RequestBody List<SuperPower> powers, @PathVariable Long id) {
        return villainServiceImpl.addSuperPowers(id, powers);
    }

    @PutMapping(tag + "allies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperVillain addAllies(@RequestBody List<SuperVillain> allies, @PathVariable Long id) {
        return villainServiceImpl.addAllies(id, allies);
    }

    @PutMapping(tag + "enemies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperVillain addEnemies(@RequestBody List<SuperHero> enemies, @PathVariable Long id) {
        return villainServiceImpl.addEnemies(id, enemies);
    }

    @PutMapping(tag + "universe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperVillain addUniverse(@RequestBody Universe universe, @PathVariable Long id) {
        return villainServiceImpl.addUniverse(id, universe);
    }

    @PutMapping(tag + "alterego/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperVillain addAlterEgo(@RequestBody Person person, @PathVariable Long id) {
        return villainServiceImpl.addAlterEgo(id, person);
    }

}
