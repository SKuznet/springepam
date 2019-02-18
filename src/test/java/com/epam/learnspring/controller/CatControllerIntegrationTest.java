package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Cat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.*;

public class CatControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/cat";
    private final static String ADD = "/add";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET_BY_ID = "/get";
    private final static String GET_ALL = "/all";

    @After
    public void cleanUp() {
        // clear all data from DB
    }

    @Before
    public void init() {
        // clear all data from DB
    }

    @Test
    public void checkCatAdding() {
        Cat cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Cat catFromDB = responseEntity.getBody();
        assertNotNull(catFromDB);

    }

    @Test
    public void checkAllCats() {
        RestTemplate template = new RestTemplate();

        createCat();
        createCat();

        ResponseEntity<List<Cat>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );

        List<Cat> catList = result.getBody();
        assertNotNull(catList);
    }

    @Test
    public void checkCatsDeletion() {
        Cat cat = createCat();

        assertNotNull(cat);

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> entity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals(HttpStatus.OK, entity.getStatusCode());

        ResponseEntity<Cat> deletedEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertNull(deletedEntity.getBody());
    }

    private Cat createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat();
        HttpEntity<Cat> entity = new HttpEntity<>(cat, headers);
        RestTemplate template = new RestTemplate();
        Cat createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Cat.class
        ).getBody();

        assertNotNull(createdCat.getId());
        assertEquals("Barsik", createdCat.getName());
        return createdCat;
    }

    private Cat prefillCat() {
        Cat cat = new Cat();
        cat.setName("Barsik");
        cat.setDescription("Hungry");
        return cat;
    }
}
