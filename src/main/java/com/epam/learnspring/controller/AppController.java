package com.epam.learnspring.controller;

import com.epam.learnspring.model.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private AnimalService animalService;

    public AnimalService getAnimalService() {
        return animalService;
    }

    @Autowired
    @Qualifier(value = "dog")
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

//    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
//    private Dog barsik = applicationContext.getBean("dog", Dog.class);

    // http://localhost:8080/cat
    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
        return "cat";
    }

    @RequestMapping("/user")
    public String getUserInfo() {
        return "user";
    }

    @RequestMapping("/admin")
    public String getAdminInfo() {
        return "admin";
    }

    @Secured({"ROLE_USER, ROLE_ADMIN"})
    @RequestMapping("/password/{password}")
    public String getAdminInfo(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
