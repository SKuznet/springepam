package com.epam.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", "Barsik");
        return "cat";
    }
}
