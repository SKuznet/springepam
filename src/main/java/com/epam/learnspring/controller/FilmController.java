package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Film;
import com.epam.learnspring.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/film")
@Controller
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Film add(@RequestBody Film film) {
        return filmService.add(film);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Film delete(@PathVariable(value = "id") long id) {
        return filmService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Film getById(@PathVariable(value = "id") long id) {
        return filmService.getById(id);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Film getByName(@PathVariable(value = "name") String name) {
        return filmService.getByName(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Film> getAll() {
        return filmService.getAll();
    }
}
