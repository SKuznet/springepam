package com.epam.learnspring.controller;

import com.epam.learnspring.model.Hero;
import com.epam.learnspring.model.HeroService;
import com.epam.learnspring.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    @Value("Demon Hunter")
    private Message message;

    @Autowired
    //@Qualifier(value = "warden")
    private HeroService heroService;

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
    private Hero warden = applicationContext.getBean("hero", Hero.class);

    @RequestMapping("/heroes")
    public String getEatInfo(Model model) {
        model.addAttribute("name", heroService.getName());
        model.addAttribute("nameFromXml", warden.getName());
        return "hero";
    }

    @RequestMapping("/user")
    public String getUserInfo() {
        return "user";
    }

    @RequestMapping("/admin")
    public String getAdminInfo() {
        return "admin";
    }

    //@Secured({"ROLE_USER, ROLE_ADMIN"})
    @RequestMapping("/password/{password}")
    public String getAdminInfo(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

}
