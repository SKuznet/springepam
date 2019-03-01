package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Author;
import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    public AuthorService authorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Author add(@RequestBody Author author) {
        return authorService.add(author);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json;charset=utf-8",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Author> getAll() {
        List<Author> all = authorService.getAll();
        return all;
    }

    @RequestMapping(value = "/addBook/{id}/{bookId}",method = RequestMethod.POST,
            produces = "application/json;charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Author addBook(@PathVariable long bookId, @PathVariable long id) {
        return authorService.addBook(bookId,id);
    }
}
