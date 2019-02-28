package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.EmployeeDao;
import com.epam.learnspring.dto.EmployeeDto;
import com.epam.learnspring.entity.Employee;
import com.epam.learnspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeDto employeeDto;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, EmployeeDto employeeDto) {
        this.employeeDao = employeeDao;
        this.employeeDto = employeeDto;
    }

    @Override
    public Employee add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee delete(long id) {
        return employeeDao.delete(employeeDao.getById(id));
    }

    @Override
    public EmployeeDto getById(long id) {
        return employeeDto.getEmployeeDtoFromEmployee(employeeDao.getById(id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }
}
