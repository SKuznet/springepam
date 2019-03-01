package com.epam.learnspring.controller;

import com.epam.learnspring.entity.Category;
import com.epam.learnspring.entity.Film;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CategoryControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/employee";
    private final static String ADD = "/add";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET_BY_ID = "/get";
    private final static String GET_ALL = "/all";

    @Test
    public void checkCategoryAdding() {
        Category category = createCategory();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Category> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Category.class,
                category.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Category categoryFromDB = responseEntity.getBody();
        assertNotNull(categoryFromDB);

    }

    private Category createCategory() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Category category = prefillCategory();
        HttpEntity<Category> entity = new HttpEntity<>(category, headers);
        RestTemplate template = new RestTemplate();
        Category createdCategory = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Category.class
        ).getBody();

        assertNotNull(createdCategory.getId());
        assertEquals("Detective", createdCategory.getName());
        return createdCategory;
    }

    private Category prefillCategory() {
        Category category = new Category();
        category.setName("Detective");
        category.setDescription("...");

        Film film1 = new Film();
        film1.setName("Film1");
        film1.setYear(LocalDate.of(2017, 11, 2));

        Film film2 = new Film();
        film2.setName("Film2");
        film2.setYear(LocalDate.of(2005, 2, 3));

        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);

        category.setFilmList(films);
        return category;
    }
}
