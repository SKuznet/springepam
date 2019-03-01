package com.epam.learnspring.service;

import com.epam.learnspring.dto.EmployeeDto;
import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.util.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    Employee add(EmployeeRequest employeeRequest);
    Employee update(Employee employee);
    Employee delete(long id);
    EmployeeDto getById(long id);
    List<Employee> getAllEmployees();
}
