package com.epam.learnspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTableCreationStatus() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
//        try {
//            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
//                    "(\n" +
//                    "    id integer NOT NULL,\n" +
//                    "    name character varying(255) COLLATE pg_catalog.\"default\",\n" +
//                    "    description character varying(255) COLLATE pg_catalog.\"default\",\n" +
//                    "    CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
//                    ")");
//            return "table created";
//        } catch (Exception e) {
            return "table creation failed";
//        }
    }

}
