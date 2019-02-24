package com.epam.learnspring.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Knight {

    private String name;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
