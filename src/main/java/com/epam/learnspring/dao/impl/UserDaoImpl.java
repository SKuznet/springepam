package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.UserDao;
import com.epam.learnspring.entity.User;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }
    @Override
    public User getByLogin(String login) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot);
        criteriaQuery.where(builder.equal(userRoot.get("login"),login));
        Query<User> query = getSession().createQuery(criteriaQuery);
        User singleResult = query.getSingleResult();
        return singleResult;
    }
}
