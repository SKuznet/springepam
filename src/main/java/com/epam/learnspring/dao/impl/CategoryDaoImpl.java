package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.CategoryDao;
import com.epam.learnspring.entity.Category;

public class CategoryDaoImpl extends BasicDaoImpl<Category> implements CategoryDao {
    public CategoryDaoImpl(Class<Category> entityClass) {
        super(entityClass);
    }

}
