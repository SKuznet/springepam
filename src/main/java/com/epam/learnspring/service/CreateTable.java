package com.epam.learnspring.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTableCreationStatus() {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cars");
            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(255),\n" +
                    "  description character varying(255),\n" +
                    "  CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
    }

}
