package com.epam.learnspring.controller;

import com.epam.learnspring.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    @Value("Murzik")
    private Message message;

    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", message.getInfo());
        return "cat";
    }
}