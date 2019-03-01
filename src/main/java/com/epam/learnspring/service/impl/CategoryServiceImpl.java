package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.CategoryDao;
import com.epam.learnspring.entity.Category;
import com.epam.learnspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public Category delete(long id) {
        return categoryDao.delete(categoryDao.getById(id));
    }

    @Override
    public Category getById(long id) {
        return categoryDao.getById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
