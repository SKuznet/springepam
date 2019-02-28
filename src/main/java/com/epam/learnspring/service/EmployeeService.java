package com.epam.learnspring.service;

import com.epam.learnspring.dto.EmployeeDto;
import com.epam.learnspring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee);
    Employee update(Employee employee);
    Employee delete(long id);
    EmployeeDto getById(long id);
    List<Employee> getAllEmployees();
}
