package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.CatDao;
import com.epam.learnspring.entity.Cat;

import java.util.List;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {
    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }

    public List<Cat> getCatListByName(String name) {
       List<Cat> cats =  getSession().createQuery("from Cat where name = ?1").setParameter(1, name).list();
       return cats;
    }
}
