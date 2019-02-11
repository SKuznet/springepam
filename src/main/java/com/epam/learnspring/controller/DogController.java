package com.epam.learnspring.controller;

import com.epam.learnspring.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DogController {

    @Qualifier("firstDog")
    @Autowired
    DogService dogService;

    @RequestMapping("/dog")
    public String getDogBark(Model model) {
        model.addAttribute("name", dogService.getName());
        model.addAttribute("bark", dogService.getBark());
        return "dog";
    }

}
