package com.epam.learnspring.controller;

import com.epam.learnspring.entity.SuperPower;
import com.epam.learnspring.service.impl.SuperPowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SuperPowerController {

    private final String ROOT = "/superpowers";
    @Autowired
    SuperPowerServiceImpl superPowerServiceImpl;

    @GetMapping(value = ROOT + "/all", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SuperPower> getSuperPowers() {
        return superPowerServiceImpl.getAll();
    }

    @GetMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperPower getSuperPowersById(@PathVariable long id) {
        return superPowerServiceImpl.getById(id);
    }

    @PostMapping(value = ROOT + "/add", produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSuperPower(@RequestBody SuperPower superPower) {
        superPowerServiceImpl.add(superPower);
    }

    @DeleteMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSuperPowers(@PathVariable long id) {
        superPowerServiceImpl.delete(id);
    }

    @PutMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public void updateSuperPowers(@RequestBody SuperPower superPower, @PathVariable Long id) {
        superPower.setId(id);
        superPowerServiceImpl.update(superPower);
    }
}
