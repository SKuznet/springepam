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

    @Autowired
    SuperPowerServiceImpl superPowerServiceImpl;

    @GetMapping("/superpowers")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SuperPower> getSuperPowers() {
        return superPowerServiceImpl.getAll();
    }

    @GetMapping("/superpowers/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SuperPower getSuperPowersById(@PathVariable long id) {
        return superPowerServiceImpl.getById(id);
    }

    @PostMapping("superpowers/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSuperPower(@RequestBody SuperPower superPower) {
        superPowerServiceImpl.add(superPower);
    }

    @DeleteMapping("superpowers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSuperPowers(@PathVariable long id) {
        superPowerServiceImpl.delete(id);
    }

    @PutMapping("superpowers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSuperPowers(@RequestBody SuperPower superPower, @PathVariable Long id) {
        superPower.setId(id);
        superPowerServiceImpl.update(superPower);
    }
}
