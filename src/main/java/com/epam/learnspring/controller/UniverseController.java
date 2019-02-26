package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Universe;
import com.epam.learnspring.service.impl.UniverseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class UniverseController {

    @Autowired
    UniverseServiceImpl universeService;

    @GetMapping("/universes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Universe> getUniverses() {
        return universeService.getAll();
    }

    @GetMapping("/universes/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Universe getUniversesById(@PathVariable long id) {
        return universeService.getById(id);
    }

    @PostMapping("universes/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUniverse(@RequestBody Universe universe) {
        universeService.add(universe);
    }

    @DeleteMapping("universes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUniverse(@PathVariable long id) {
        universeService.delete(id);
    }

    @PutMapping("universes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUniverse(@RequestBody Universe universe, @PathVariable Long id) {
        universe.setId(id);
        universeService.update(universe);
    }
}
