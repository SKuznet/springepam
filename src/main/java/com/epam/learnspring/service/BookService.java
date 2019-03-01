package com.epam.learnspring.service;

import com.epam.learnspring.entity.Author;
import com.epam.learnspring.entity.Book;

import java.util.List;

public interface BookService {
    Book add(Book book);

    List<Book> getAll();
}
