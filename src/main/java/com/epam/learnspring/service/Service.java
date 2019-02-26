package com.epam.learnspring.service;

import java.util.List;

public interface Service<T> {

    T add(T t);

    T update(T t);

    T delete(long id);

    T getById(long id);

    List<T> getAll();
}
