package com.epam.learnspring.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTableCreationStatus() {
            jdbcTemplate.execute("DROP1 TABLE IF EXISTS pets");
            jdbcTemplate.execute("CREATE TABLE public.pets\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(255),\n" +
                    "  description character varying(255),\n" +
                    "  CONSTRAINT pets_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
    }

}
