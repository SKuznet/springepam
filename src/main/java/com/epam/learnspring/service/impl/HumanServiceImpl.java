package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.HumanDao;
import com.epam.learnspring.entity.Human;
import com.epam.learnspring.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanServiceImpl implements HumanService {
    private final HumanDao humanDao;

    @Autowired
    public HumanServiceImpl(HumanDao humanDao) {
        this.humanDao = humanDao;
    }

    @Override
    public Human add(Human human) {
        return humanDao.add(human);
    }

    @Override
    public Human update(Human human) {
        return humanDao.update(human);
    }

    @Override
    public Human delete(long id) {
        return humanDao.delete(getHumanById(id));
    }

    @Override
    public Human getHumanById(long id) {
        return humanDao.getById(id);
    }

    @Override
    public List<Human> getAllHumans() {
        return humanDao.getAll();
    }

}
