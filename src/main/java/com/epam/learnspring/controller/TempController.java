package com.epam.learnspring.controller;

import com.epam.learnspring.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempController {
    @Autowired
    private Dog dog;

    @RequestMapping("/temp")
    public String getTempValue(Model model){
        model.addAttribute("name", dog.getName());
        return "cat";
    }
}
