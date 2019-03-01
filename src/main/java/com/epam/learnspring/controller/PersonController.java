package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Person;
import com.epam.learnspring.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private final String ROOT = "/persons";
    @Autowired
    PersonServiceImpl personServiceImpl;

    @GetMapping(value = ROOT + "/{id}" , produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person getPersons(@PathVariable long id) {
        return personServiceImpl.getById(id);
    }

    @GetMapping(value = ROOT + "/all", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersonById() {
        return personServiceImpl.getAll();
    }

    @PostMapping(value = ROOT + "/add", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Person savePerson(@RequestBody Person person) {
        return personServiceImpl.add(person);
    }

    @DeleteMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person deletePerson(@PathVariable long id) {
        return personServiceImpl.delete(id);
    }

    @PutMapping(value = ROOT + "/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
        person.setId(id);
        return personServiceImpl.update(person);
    }

}
