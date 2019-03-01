package com.epam.learnspring.controller;

import com.epam.learnspring.service.BarbarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// localhost:8080/knight/*
@RequestMapping("/barbarian")
public class BarbarianController {

    private BarbarianService barbarianService;

    @RequestMapping("/info")
    public String getBarbarianInfo(Model model) {
        model.addAttribute("action", barbarianService.getAchievement("dragon"));
        return "Barbarian";
    }

    public BarbarianService getBarbarianService() {
        return barbarianService;
    }

    @Autowired
    public void setBarbarianService(BarbarianService barbarianService) {
        this.barbarianService = barbarianService;
    }
}
