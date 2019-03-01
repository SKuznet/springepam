package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.FilmDao;
import com.epam.learnspring.entity.Film;

public class FilmDaoImpl extends BasicDaoImpl<Film> implements FilmDao {
    public FilmDaoImpl(Class<Film> entityClass) {
        super(entityClass);
    }

    @Override
    public Film getByName(String name) {
        Film film = new Film();
        film.setName("Name");
        return film;
    }
}
