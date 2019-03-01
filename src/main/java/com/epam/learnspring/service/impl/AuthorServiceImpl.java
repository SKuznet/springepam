package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.AuthorDao;
import com.epam.learnspring.dao.BookDao;
import com.epam.learnspring.entity.Author;
import com.epam.learnspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    public AuthorDao authorDao;

    @Autowired
    public BookDao bookDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @Override
    public Author addBook(Long bookId, Long id) {
        Author author = authorDao.getById(id);
        author.getBooks().add(bookDao.getById(bookId));
        return authorDao.update(author);
    }
}
