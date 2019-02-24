package com.epam.learnspring.controller;

import com.epam.learnspring.model.Message;
import com.epam.learnspring.model.User;
import com.epam.learnspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

//    // AppConfig - BEAN
//    @Autowired
//    private Message message;

    // Message - Constructor
    @Value("Murzik")
    private Message message;

    // XML - context
//    private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private User user = (User) context.getBean("user");

    @Autowired
    @Qualifier(value = "vladUserImpl")
    private UserService userService;

    @RequestMapping("/cat")
    public String getCatInfo(Model model) {
        model.addAttribute("name", userService.getName());
//        model.addAttribute("username", user.getName());
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

    @RequestMapping("/password/{password}")
    public String getAdminInfo(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

}