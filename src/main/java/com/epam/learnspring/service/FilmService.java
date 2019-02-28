package com.epam.learnspring.service;

import com.epam.learnspring.entity.Film;

import java.util.List;

public interface FilmService {

    Film add(Film film);
    Film update(Film film);
    Film delete(long id);
    Film getById(long id);
    List<Film> getAll();
}
