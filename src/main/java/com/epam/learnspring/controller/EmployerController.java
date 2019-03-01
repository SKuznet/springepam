package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.service.EmployerService;
import com.epam.learnspring.util.EmployeeRequest;
import com.epam.learnspring.util.EmployerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employer")
@Controller
public class EmployerController {
    @Autowired
    public EmployerService employerService;



    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Employer addEmployee(@RequestBody Employer employer) {
        return employerService.add(employer);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    List<Employer> getAll() {
        List<Employer> all = employerService.getAll();
        return all;
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    Employer update(@RequestBody EmployerRequest employerRequest) {
        Employer update = employerService.update(employerRequest);
        return update;
    }




}
