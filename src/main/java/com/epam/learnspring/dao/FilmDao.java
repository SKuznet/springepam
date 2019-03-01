package com.epam.learnspring.dao;

import com.epam.learnspring.entity.Film;

public interface FilmDao extends BasicDao<Film> {
    Film getByName(String name);
}
