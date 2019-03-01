package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.UserDao;
import com.epam.learnspring.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    public List<User> getUsersByPosition (String position) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        List<User> listOfUsers = getSession().createQuery(criteriaQuery).list();

        return listOfUsers.stream().filter(user -> user.getPosition().equals(position)).collect(Collectors.toList());
    }
}
