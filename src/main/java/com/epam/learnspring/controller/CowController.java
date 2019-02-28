package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Cow;
import com.epam.learnspring.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cows")
public class CowController {
    private CowService cowService;

    @Autowired
    public CowController(CowService cowService) {
        this.cowService = cowService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddCowPage(Cow cow) {
        return "addcow";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String addCow(Cow cow, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addcow";
        }
        cow.setBull(null);
        cow.setUdder(null);
        cowService.add(cow);
        return "redirect:/cows";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Cow updateCow(@RequestBody Cow cow) {
        return cowService.update(cow);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public String deleteCow(@PathVariable(value = "id") Long id) {

        //TODO why return NULL?
        cowService.delete(id);
        if (cowService.delete(id)!=null){
            System.out.println("NULL in deleteCow and CowController");
        }
        return "redirect:/cows";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCowById(@PathVariable(value = "id") Long id, Model model) {
        Cow cow = cowService.getCowById(id);
        model.addAttribute("cow", cowService.getCowById(id));
        return "cow";
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getAllCows(Model model) {

        model.addAttribute("cows", cowService.getAll());
        model.addAttribute("totalElements", cowService.getAll().size());
        return "cowslist";
    }
}