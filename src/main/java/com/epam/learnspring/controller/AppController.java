package com.epam.learnspring.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    // http://localhost:8080/cat
    @RequestMapping("/cat")
    @Secured({"ROLE_USER, ROLE_ADMIN"})
    public String getCatInfo(Model model) {
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
        return "cat";
    }

    @RequestMapping("/")
    public String getMenu() {
        return "catcrud";
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
