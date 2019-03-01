package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.BookDao;
import com.epam.learnspring.entity.Book;
import com.epam.learnspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
