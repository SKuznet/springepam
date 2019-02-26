package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.PersonDao;
import com.epam.learnspring.entity.Person;

public class PersonDaoImpl extends BasicDaoImpl<Person> implements PersonDao {

    public PersonDaoImpl(Class<Person> entityClass) {
        super(entityClass);
    }

}
