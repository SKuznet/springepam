package com.epam.learnspring.controller;

import com.epam.learnspring.dto.RockerDto;
import com.epam.learnspring.entity.Rocker;
import com.epam.learnspring.service.RockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rocker")
@Controller
public class RockerController {

    private final RockerService rockerService;

    @Autowired
    public RockerController(RockerService rockerService) {
        this.rockerService = rockerService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Rocker addRocker(@RequestBody Rocker rocker) {
        return rockerService.add(rocker);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Rocker addUpdate(@RequestBody Rocker rocker) {
        return rockerService.update(rocker);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Rocker delete(@PathVariable(value = "id") long id) {
        return rockerService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public RockerDto getRockerDtoById(@PathVariable(value = "id") long id) {
        return rockerService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Rocker> getAllRockers() {
        return rockerService.getAllRockers();
    }
}
