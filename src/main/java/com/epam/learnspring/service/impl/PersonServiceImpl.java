package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.PersonDao;
import com.epam.learnspring.entity.Person;
import com.epam.learnspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person add(Person person) {
        return personDao.add(person);
    }

    @Override
    public Person update(Person person) {
        return personDao.update(person);
    }

    @Override
    public Person delete(long id) {
        return personDao.delete(getById(id));
    }

    @Override
    public Person getById(long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }
}
