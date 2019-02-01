package com.epam.learnspring.service;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTableCreationStatus() {

        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n)" +
                    "id integer NOT NULL,\n" +
                    "");
            return "table created";
        }
        catch (Exception e) {
            return "table creation failed";
        }
    }
}
