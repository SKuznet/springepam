package com.epam.learnspring.controller;

import com.epam.learnspring.dto.RockerDto;
import com.epam.learnspring.entity.City;
import com.epam.learnspring.entity.Rocker;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RockerControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/employee";
    private final static String ADD = "/add";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET_BY_ID = "/get";
    private final static String GET_ALL = "/all";

    @Test
    public void checkEmployeeAdding() {
        Rocker rocker = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<RockerDto> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                RockerDto.class,
                rocker.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        RockerDto employeeFromDB = responseEntity.getBody();
        assertNotNull(employeeFromDB);

    }

    private Rocker createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Rocker rocker = prefillEmployee();
        HttpEntity<Rocker> entity = new HttpEntity<>(rocker, headers);
        RestTemplate template = new RestTemplate();
        Rocker createdRocker = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Rocker.class
        ).getBody();

        assertNotNull(createdRocker.getId());
        assertEquals("Mark", createdRocker.getName());
        return createdRocker;
    }

    private Rocker prefillEmployee() {
        Rocker rocker = new Rocker();
        rocker.setName("Mark");
        rocker.setGenre("manager");

        City lada = new City();
        lada.setModel("Lada");
        lada.setYear(LocalDate.of(2017, 11, 2));

        City bmw = new City();
        bmw.setModel("BMW");
        bmw.setYear(LocalDate.of(2005, 2, 3));

        List<City> cities = new ArrayList<>();
        cities.add(lada);
        cities.add(bmw);

        rocker.setCityList(cities);
        return rocker;
    }
}
