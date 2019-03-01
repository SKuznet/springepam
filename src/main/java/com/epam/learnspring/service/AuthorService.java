package com.epam.learnspring.service;


import com.epam.learnspring.entity.Author;

import java.util.List;

public interface AuthorService {
    Author add(Author author);
    List<Author> getAll();
    Author addBook(Long bookId, Long id);
}
