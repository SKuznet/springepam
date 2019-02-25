package com.epam.learnspring.dao;

import com.epam.learnspring.entity.Cat;

import java.util.List;

public interface CatDao extends BasicDao<Cat> {
    List<Cat> getCatListByName(String name);
}
