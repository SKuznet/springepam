package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.AuthorDao;
import com.epam.learnspring.entity.Author;

public class AuthorDaoImpl extends BasicDaoImpl<Author> implements AuthorDao {
    public AuthorDaoImpl(Class<Author> entityClass) {
        super(entityClass);
    }
}
