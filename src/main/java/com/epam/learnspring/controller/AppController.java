package com.epam.learnspring.controller;

import com.epam.learnspring.model.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    @Qualifier(value = "dog")
    private AnimalService animalService;

    //private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
    //private Dog barsik = applicationContext.getBean("dog", Dog.class);

    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", animalService.getName());
        return "cat";
    }
}
