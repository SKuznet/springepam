package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.EmployerDao;
import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.util.EmployerRequest;
import org.hibernate.Session;

import java.io.Serializable;

public class EmployerDaoImpl extends BasicDaoImpl<Employer> implements EmployerDao{
    public EmployerDaoImpl(Class<Employer> entityClass) {
        super(entityClass);
    }

    @Override
    public Employer update(EmployerRequest employerRequest) {
        Session session = getSession();
        Employer employer = session.get(Employer.class, employerRequest.getId());
        employer.setName(employerRequest.getName());
        Employee employee = session.get(Employee.class,employerRequest.getEmployeeId());
        employer.setEmployee(employee);
        Long id = (Long) session.save(employer);
        return session.get(Employer.class,id);
    }
}
