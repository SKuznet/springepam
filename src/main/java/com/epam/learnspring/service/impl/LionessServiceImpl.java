package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.LionessDao;
import com.epam.learnspring.entity.Lioness;
import com.epam.learnspring.service.LionessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LionessServiceImpl implements LionessService {
    private final LionessDao lionDao;

    @Autowired
    public LionessServiceImpl(LionessDao lionDao) {
        this.lionDao = lionDao;
    }

    @Override
    public Lioness add(Lioness lioness) {
        return lionDao.add(lioness);
    }

    @Override
    public Lioness update(Lioness lioness) {
        return lionDao.update(lioness);
    }

    @Override
    public Lioness delete(Long id) {
        return lionDao.delete(getLionessById(id));
    }

    @Override
    public Lioness getLionessById(Long id) {
        return lionDao.getById(id);
    }

    @Override
    public List<Lioness> getAll() {
        return lionDao.getAll();
    }
}