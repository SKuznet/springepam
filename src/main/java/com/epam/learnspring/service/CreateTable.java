package com.epam.learnspring.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTableCreationStatus() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS lion");
        jdbcTemplate.execute("CREATE TABLE public.lion\n" +
                "(\n" +
                "  id integer NOT NULL,\n" +
                "  name character varying(255),\n" +
                "  description character varying(255),\n" +
                "  CONSTRAINT lion_pkey PRIMARY KEY (id)\n" +
                ")");
        return "table created";
    }
}