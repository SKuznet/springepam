package com.epam.learnspring.controller;
import com.epam.learnspring.service.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warden")
public class WardenController {

    private WardenService wardenService;

    @RequestMapping("/info")
    public String getWardenInfo(Model model) {
        model.addAttribute("action", wardenService.getAchievement("Demon Hunter"));
        model.addAttribute("song", wardenService.getSong("The guilty will be punished"));
        return "warden";
    }

    public WardenService getWardenService() {
        return wardenService;
    }

    @Autowired
    public void setWardenService(WardenService wardenService) {
        this.wardenService = wardenService;
    }
}
