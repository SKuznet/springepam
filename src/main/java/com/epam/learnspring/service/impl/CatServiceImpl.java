package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.CatDao;
import com.epam.learnspring.entity.Cat;
import com.epam.learnspring.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private final CatDao catDao;

    @Autowired
    public CatServiceImpl(CatDao catDao) {
        this.catDao = catDao;
    }

    @Override
    public Cat add(Cat cat) {
        return catDao.add(cat);
    }

    @Override
    public Cat update(Cat cat) {
        return catDao.update(cat);
    }

    @Override
    public Cat delete(long id) {
        return catDao.delete(getCatById(id));
    }

    @Override
    public Cat getCatById(long id) {
        return catDao.getById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catDao.getAll();
    }

}
