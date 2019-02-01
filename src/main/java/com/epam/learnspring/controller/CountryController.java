package com.epam.learnspring.controller;

import com.epam.learnspring.model.Country;
import com.epam.learnspring.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountryController {
    private CountryService countryService;
    private ApplicationContext appContext = new ClassPathXmlApplicationContext("ioc.xml");
    private Country country = appContext.getBean("country", Country.class);

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping (value = "/country", method = RequestMethod.GET)
    public String getPage(Model model) {
        model.addAttribute("country", new Country("Russia", 148_000_000, "Moscow"));
        model.addAttribute("beanCountry", country);
        model.addAttribute("serviceCountry", countryService.getLanguage());
        return "country";
    }
}
