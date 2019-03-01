package com.epam.learnspring.dao;

import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.util.EmployeeRequest;

public interface EmployeeDao extends BasicDao<Employee> {
    Employee add(EmployeeRequest employeeRequest);
}
