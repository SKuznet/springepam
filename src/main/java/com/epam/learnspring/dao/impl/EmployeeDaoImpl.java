package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.EmployeeDao;
import com.epam.learnspring.entity.Employee;

public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }
}
