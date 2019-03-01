package com.epam.learnspring.dto;

import com.epam.learnspring.entity.Employee;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private String title;

    public EmployeeDto getEmployeeDtoFromEmployee(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setId(employee.getId());
        return employeeDto;
    }
}
