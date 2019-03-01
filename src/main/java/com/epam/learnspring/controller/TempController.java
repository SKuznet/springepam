package com.epam.learnspring.controller;

import com.epam.learnspring.model.Lion;
import com.epam.learnspring.service.LionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TempController {

//    @Autowired
    //  private LionService lionService;

    @Value("Tom")
    private Lion lion;

    @RequestMapping("/temp")
    public String getTempValue(Model model) {
        model.addAttribute("name", lion.getName());
        model.addAttribute("nameFromXml", 123);
        return "lion";
    }
}

