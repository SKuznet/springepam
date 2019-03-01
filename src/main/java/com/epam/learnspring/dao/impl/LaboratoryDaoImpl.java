package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.LaboratoryDao;
import com.epam.learnspring.entity.Laboratory;
import com.epam.learnspring.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.prefs.Preferences;

public class LaboratoryDaoImpl extends BasicDaoImpl<Laboratory> implements LaboratoryDao {
    public LaboratoryDaoImpl(Class<Laboratory> entityClass) {
        super(entityClass);
    }

    public User getChiefByID (long id) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Laboratory> criteriaQuery = builder.createQuery(Laboratory.class);
        Root<Laboratory> root = criteriaQuery.from(Laboratory.class);
        criteriaQuery.select(root);
        List<Laboratory> listOfUsers = getSession().createQuery(criteriaQuery).list();

        return listOfUsers.stream().filter(laboratory -> laboratory.getId() == id)
                .map(Laboratory::getChief).reduce(null, ((user, user2) -> user));
    }
}
