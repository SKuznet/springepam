package com.epam.learnspring.controller;

import com.epam.learningspring.entity.Pet;
import com.epam.learningspring.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Pet")
public class PetController {

    @Autowired
    private  PetService PetService;


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "appliPetion/json;charset=utf-8")
    @ResponseBody
    public Pet addPet(@RequestBody Pet pet) {
        return PetService.add(pet);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "appliPetion/json;charset=utf-8")
    @ResponseBody
    public Pet addUpdate(@RequestBody Pet pet) {
        return PetService.update(pet);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "appliPetion/json;charset=utf-8")
    @ResponseBody
    public Pet addUpdate(@PathVariable(value = "id") long id) {
        return PetService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "appliPetion/json;charset=utf-8")
    @ResponseBody
    public Pet getPetById(@PathVariable(value = "id") long id) {
        return PetService.getPetById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "appliPetion/json;charset=utf-8")
    @ResponseBody
    public List<Pet> getAllPets() {
        return PetService.getAllPets();
    }

}
