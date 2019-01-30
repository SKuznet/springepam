package com.epam.learnspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", "Hello world!");
        return "cat";
    }
}
