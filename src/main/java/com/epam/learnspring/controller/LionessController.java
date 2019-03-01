package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Lioness;
import com.epam.learnspring.service.LionessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/lionesses")
public class LionessController {
    private LionessService lionessService;

    @Autowired
    public LionessController(LionessService lionessService) {
        this.lionessService = lionessService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddLionessPage(Lioness lioness) {
        return "addlioness";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String add(Lioness lioness, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addlioness";
        }
        lioness.setLion(null);
        lioness.setZebra(null);
        lionessService.add(lioness);
        return "redirect:/lionesses";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT,
            produces = "application/json;charset=utf-8")
    public Lioness update(@RequestBody Lioness lioness) {
        return lionessService.update(lioness);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public String delete(@PathVariable(value = "id") Long id) {
        lionessService.delete(id);
        return "redirect:/lionesses";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getLionessById(@PathVariable(value = "id") Long id, Model model) {
                model.addAttribute("lioness", lionessService.getLionessById(id));
        return "lioness";
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getAllLioness(Model model) {

        model.addAttribute("lionesses", lionessService.getAll());
        model.addAttribute("totalElements", lionessService.getAll().size());
        return "lionessList";
    }
}