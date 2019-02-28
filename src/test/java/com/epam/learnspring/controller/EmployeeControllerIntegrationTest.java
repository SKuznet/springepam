package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Car;
import com.epam.learnspring.entity.Employee;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/employee";
    private final static String ADD = "/add";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET_BY_ID = "/get";
    private final static String GET_ALL = "/all";

    @Test
    public void checkEmployeeAdding() {
        Employee employee = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Employee> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Employee.class,
                employee.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Employee employeeFromDB = responseEntity.getBody();
        assertNotNull(employeeFromDB);

    }

    private Employee createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();
        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        RestTemplate template = new RestTemplate();
        Employee createdEmployee = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Employee.class
        ).getBody();

        assertNotNull(createdEmployee.getId());
        assertEquals("Mark", createdEmployee.getName());
        return createdEmployee;
    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Mark");
        employee.setTitle("manager");

        Car lada = new Car();
        lada.setModel("Lada");
        lada.setYear(LocalDate.of(2017, 11, 2));

        Car bmw = new Car();
        bmw.setModel("BMW");
        bmw.setYear(LocalDate.of(2005, 2, 3));

        List<Car> cars = new ArrayList<>();
        cars.add(lada);
        cars.add(bmw);

        employee.setCarList(cars);
        return employee;
    }
}
