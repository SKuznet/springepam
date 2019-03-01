package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.HumanDao;
import com.epam.learnspring.entity.Human;

import java.util.List;

public class HumanDaoImpl extends BasicDaoImpl<Human> implements HumanDao {
    public HumanDaoImpl(Class<Human> entityClass) {
        super(entityClass);
    }

    public List<Human> getCatListByName(String name) {
       List<Human> humans =  getSession().createQuery("from Human where name = ?1").setParameter(1, name).list();
       return humans;
    }
}
