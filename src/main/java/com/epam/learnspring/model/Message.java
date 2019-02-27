package com.epam.learnspring.model;

import org.springframework.stereotype.Service;

@Service
public class Message {
    private String info;

    public Message() {
    }

    public Message(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
