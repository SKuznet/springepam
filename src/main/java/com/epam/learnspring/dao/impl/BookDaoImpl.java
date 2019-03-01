package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.BookDao;
import com.epam.learnspring.entity.Book;

public class BookDaoImpl extends BasicDaoImpl<Book> implements BookDao {
    public BookDaoImpl(Class<Book> entityClass) {
        super(entityClass);
    }
}
