package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Universe;
import com.epam.learnspring.service.impl.UniverseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UniverseController {

    @Autowired
    UniverseServiceImpl universeService;

    private final String ROOT = "/universes";

    @GetMapping(value = ROOT + "/all", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Universe> getUniverses() {
        return universeService.getAll();
    }

    @GetMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Universe getUniversesById(@PathVariable long id) {
        return universeService.getById(id);
    }

    @PostMapping(value = ROOT + "/add", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Universe saveUniverse(@RequestBody Universe universe) {
        return universeService.add(universe);
    }

    @DeleteMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Universe deleteUniverse(@PathVariable long id) {
        return universeService.delete(id);
    }

    @PutMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Universe updateUniverse(@RequestBody Universe universe, @PathVariable Long id) {
        universe.setId(id);
        return universeService.update(universe);
    }
}
