package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Human;
import com.epam.learnspring.entity.Home;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HumanControllerIntegrationTest {

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
        Human human = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Human> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Human.class,
                human.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Human humanFromDB = responseEntity.getBody();
        assertNotNull(humanFromDB);

    }

    @Test
    public void checkAllCats() {
        RestTemplate template = new RestTemplate();

        createCat();
        createCat();

        ResponseEntity<List<Human>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Human>>() {
                }
        );

        List<Human> humanList = result.getBody();
        assertNotNull(humanList);
    }

    @Test
    public void checkCatsDeletion() {
        Human human = createCat();

        assertNotNull(human);

        RestTemplate template = new RestTemplate();
        ResponseEntity<Human> entity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Human.class,
                human.getId()
        );

        assertEquals(HttpStatus.OK, entity.getStatusCode());

        ResponseEntity<Human> deletedEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Human.class,
                human.getId()
        );

        assertNull(deletedEntity.getBody());
    }

    private Human createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Human human = prefillCat();
        HttpEntity<Human> entity = new HttpEntity<>(human, headers);
        RestTemplate template = new RestTemplate();
        Human createdHuman = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Human.class
        ).getBody();

        assertNotNull(createdHuman.getId());
        assertEquals("Barsik", createdHuman.getName());
        return createdHuman;
    }

    private Human prefillCat() {
        Human human = new Human();
        human.setName("Barsik");
        human.setDescription("Hungry");

        Home riska = new Home();
        riska.setName("Riska");
        riska.setDescription("Good");

        Home murka = new Home();
        murka.setName("Murka");
        murka.setDescription("angry");

        List<Home> catWomens = new ArrayList<>();
        catWomens.add(riska);
        catWomens.add(murka);

        human.setHomeList(catWomens);
        return human;
    }
}
