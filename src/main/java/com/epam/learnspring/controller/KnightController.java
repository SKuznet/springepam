package com.epam.learnspring.controller;

import com.epam.learnspring.model.Knight;
import com.epam.learnspring.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/knight")
public class KnightController {

    private KnightService knightService;

    @RequestMapping("/info")
    public String getKnightInfo(Model model) {
        model.addAttribute("action", knightService.getAchievement("dragon"));
        return "knight";
    }

    public KnightService getKnightService() {
        return knightService;
    }

    @Autowired
    public void setKnightService(KnightService knightService) {
        this.knightService = knightService;
    }
}
