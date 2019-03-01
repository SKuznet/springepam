package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Human;
import com.epam.learnspring.service.HumanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/human")
public class HumanController {
    private final HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Human addHuman(@RequestBody Human human) {
        return humanService.add(human);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Human addUpdate(@RequestBody Human human) {
        return humanService.update(human);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Human addUpdate(@PathVariable(value = "id") long id) {
        return humanService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Human getHumanById(@PathVariable(value = "id") long id) {
        return humanService.getHumanById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Human> getAllHumans() {
        return humanService.getAllHumans();
    }

}
