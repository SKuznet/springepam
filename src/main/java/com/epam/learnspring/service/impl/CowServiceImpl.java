package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.CowDao;
import com.epam.learnspring.entity.Cow;
import com.epam.learnspring.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CowServiceImpl implements CowService {
    private final CowDao cowDao;

    @Autowired
    public CowServiceImpl(CowDao cowDao) {
        this.cowDao = cowDao;
    }

    @Override
    public Cow add(Cow cow) {
        return cowDao.add(cow);
    }

    @Override
    public Cow update(Cow cow) {
        return cowDao.update(cow);
    }

    @Override
    public Cow delete(Long id) {
        return cowDao.delete(getCowById(id));
    }

    @Override
    public Cow getCowById(Long id) {
        return cowDao.getById(id);
    }

    @Override
    public List<Cow> getAll() {
        return cowDao.getAll();
    }
}