package com.epam.learnspring.dao;

import com.epam.learnspring.entity.Cat;

import java.util.List;

public interface BasicDao<T> {

    T add(T entity);

    T update(T entity);

    T delete(T entityById);

    T getById(long id);

    List<T> getAll();
}
