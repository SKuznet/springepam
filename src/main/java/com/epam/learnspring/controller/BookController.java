package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Author;
import com.epam.learnspring.entity.Book;
import com.epam.learnspring.service.AuthorService;
import com.epam.learnspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    public BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    Book add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    List<Book> getAll() {
        List<Book> all = bookService.getAll();
        return all;
    }
}
