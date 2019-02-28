package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.FilmDao;
import com.epam.learnspring.entity.Film;
import com.epam.learnspring.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("filmService")
public class FilmServiceImpl implements FilmService {
    private final FilmDao filmDao;

    @Autowired
    public FilmServiceImpl(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public Film add(Film film) {
        return filmDao.add(film);
    }

    @Override
    public Film update(Film film) {
        return filmDao.update(film);
    }

    @Override
    public Film delete(long id) {
        return filmDao.delete(filmDao.getById(id));
    }

    @Override
    public Film getById(long id) {
        return filmDao.getById(id);
    }

    @Override
    public List<Film> getAll() {
        return filmDao.getAll();
    }
}
