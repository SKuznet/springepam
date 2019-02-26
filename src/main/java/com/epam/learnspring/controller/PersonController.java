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

    @Autowired
    PersonServiceImpl personServiceImpl;

    @GetMapping("/persons/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person getPersons(@PathVariable long id) {
        return personServiceImpl.getById(id);
    }

    @GetMapping("/persons")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersonById() {
        return personServiceImpl.getAll();
    }

    @PostMapping("persons/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody Person person) {
        personServiceImpl.add(person);
    }

    @DeleteMapping("persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable long id) {
        personServiceImpl.delete(id);
    }

    @PutMapping("persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePerson(@RequestBody Person person, @PathVariable Long id) {
        person.setId(id);
        personServiceImpl.update(person);
    }

}
