package com.epam.learnspring.dao;

import com.epam.learnspring.entity.Human;

import java.util.List;

public interface HumanDao extends BasicDao<Human> {
    List<Human> getCatListByName(String name);
}
