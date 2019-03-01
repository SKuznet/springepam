package com.epam.learnspring.controller;

import com.epam.learnspring.dao.CatDao;
import com.epam.learnspring.model.AnimalService;
import com.epam.learnspring.util.CheckTextUtil;
import net.yandex.speller.services.spellservice.CheckTextRequest;
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
    private final CatDao catDao;
    private final CheckTextUtil checkTextUtil;

    @Autowired
    public AppController(CatDao catDao, CheckTextUtil checkTextUtil) {
        this.catDao = catDao;
        this.checkTextUtil = checkTextUtil;
    }

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
    @Secured({"ROLE_USER, ROLE_ADMIN"})
    public String getCatInfo(Model model) {
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
        return "cat";
    }

    @RequestMapping("/")
    public String getMenu() {
        catDao.getCatListByName("Barsik");
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

    @RequestMapping("/check/{text}")
    public String checkTextSpeller(@PathVariable("text") String text, Model model) {
        model.addAttribute("text", "text for checking:  " + text);
        model.addAttribute("var", checkTextUtil.checkText(text));
        return "spell";
    }
}
