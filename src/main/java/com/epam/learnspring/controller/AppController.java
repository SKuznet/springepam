package com.epam.learnspring.controller;

import com.epam.learnspring.model.*;
import com.epam.learnspring.model.impl.AlexLionImpl;
import com.epam.learnspring.service.LionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    @Value("Tom123")
    private Message message;

    @Autowired
    private LionService lionService;

    @Autowired
    private AlexLionImpl alexLion;

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
    private Lion alex = applicationContext.getBean("lion", Lion.class);

    @RequestMapping("/lion")
    public String getLionInfo(Model model) {
        model.addAttribute("name", alexLion.getName());
        model.addAttribute("nameFromXml", alex.getName());
        return "lion";
    }

    @RequestMapping("/user")
    public String getUserInfo() {
        return "user";
    }

    @RequestMapping("/admin")
    public String getAdminInfo() {
        return "admin";
    }

    @RequestMapping("/password/{password}")
    public String getUserInfo(@PathVariable ("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
