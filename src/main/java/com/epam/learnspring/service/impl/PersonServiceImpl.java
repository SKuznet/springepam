package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.PersonDao;
import com.epam.learnspring.entity.Person;
import com.epam.learnspring.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person add(Person person) {
        log.info("add person");
        return personDao.add(person);
    }

    @Override
    public Person update(Person person) {
        log.info("update person" + person);
        return personDao.update(person);
    }

    @Override
    public Person delete(long id) {
        log.info("delete person with id: " + id);
        return personDao.delete(getById(id));
    }

    @Override
    public Person getById(long id) {
        log.info("get person with id: " + id);
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        log.info("get all persons");
        return personDao.getAll();
    }
}
