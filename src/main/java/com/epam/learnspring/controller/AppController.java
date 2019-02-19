package com.epam.learnspring.controller;

import com.epam.learnspring.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

//    // AppConfig - BEAN
//    @Autowired
//    private Message message;

    // Message - Constructor
    @Value("Murzik")
    private Message message;

    // XML - context
//    private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private Message message = (Message) context.getBean("message");

    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", message.getInfo());
        return "cat";
    }
}