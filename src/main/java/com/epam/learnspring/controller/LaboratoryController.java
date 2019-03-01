package com.epam.learnspring.controller;

import com.epam.learnspring.dao.dto.LaboratoryDto;
import com.epam.learnspring.entity.Laboratory;
import com.epam.learnspring.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/laboratory")
@Controller
public class LaboratoryController {
    private final LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Laboratory addLaboratory(@RequestBody Laboratory laboratory) {
        return laboratoryService.add(laboratory);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Laboratory updateLaboratory(@RequestBody Laboratory laboratory) {
        return laboratoryService.update(laboratory);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Laboratory deleteLaboratory(@PathVariable(value = "id") long id) {
        return laboratoryService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public LaboratoryDto getLaboratoryDtoById(@PathVariable(value = "id") long id) {
        return laboratoryService.getUserById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Laboratory> getAllLaboratories() {
        return laboratoryService.getAllUsers();
    }
}
