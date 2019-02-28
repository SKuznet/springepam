package com.epam.springlesson2.dao.impl;

import com.epam.springlesson2.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T add(T entity) {
        getSession().save(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getSession().update(entity);
        return entity;
    }

    @Override
    public T delete(T entity) {
        getSession().delete(entity);
        return entity;
    }

    @Override
    public T getById(Long id) {
        return getSession().get(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getSession().createQuery(criteriaQuery).list();
    }
}