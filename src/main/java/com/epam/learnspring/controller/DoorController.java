package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Door;
import com.epam.learnspring.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/door")
@Controller
public class DoorController {

    private final DoorService doorService;

    @Autowired
    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Door add(@RequestBody Door door) {
        return doorService.add(door);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Door update(@RequestBody Door door) {
        return doorService.update(door);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Door delete(@PathVariable(value = "id") long id) {
        return doorService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Door getById(@PathVariable(value = "id") long id) {
        return doorService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Door> getAll() {
        return doorService.getAll();
    }
}
