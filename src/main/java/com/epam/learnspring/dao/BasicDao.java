package com.epam.learnspring.dao;

import java.util.List;

public interface BasicDao<T> {

    T add(T entity);

    T update(T entity);

    T delete(T entity);

    T getById(Long id);

    List<T> getAll();
}