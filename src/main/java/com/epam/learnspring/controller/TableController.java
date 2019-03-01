package com.epam.learnspring.controller;

import com.epam.learnspring.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/table")
public class TableController {

    private CreateTable createTable;

    @Autowired
    public TableController(CreateTable createTable) {
        this.createTable = createTable;
    }

    @GetMapping("/create")
    public String getTableCreationStatus(Model model) {
        model.addAttribute("status", createTable.getTableCreationStatus());
        return "create";
    }
}
