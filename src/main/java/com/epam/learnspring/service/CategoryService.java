package com.epam.learnspring.service;

import com.epam.learnspring.entity.Category;

import java.util.List;

public interface CategoryService {

    Category add(Category category);

    Category update(Category category);

    Category delete(long id);

    Category getById(long id);

    List<Category> getAll();
}
