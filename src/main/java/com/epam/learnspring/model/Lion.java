package com.epam.learnspring.model;


public class Lion {

    private String name;

    public Lion() {
    }

    public Lion(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}