package com.epam.learnspring.dao.impl;

import com.epam.learnspring.dao.EmployeeDao;
import com.epam.learnspring.dao.EmployerDao;
import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.util.EmployeeRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }

    @Override
    public Employee add(EmployeeRequest employeeRequest) {
        Session session = getSession();

        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSurname(employeeRequest.getSurname());
        Employer employer = session.get(Employer.class,employeeRequest.getEmployerId());
        employee.setEmployer(employer);
        employer.setEmployee(employee);
        Long id = (Long) session.save(employee);
        session.save(employer);
        return session.get(Employee.class,id);
    }
}
