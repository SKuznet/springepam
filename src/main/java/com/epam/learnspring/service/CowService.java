package com.epam.learnspring.service;

import com.epam.learnspring.entity.Cow;

import java.util.List;

public interface CowService {
    Cow add(Cow cow);

    Cow update(Cow cow);

    Cow delete(Long id);

    Cow getCowById(Long id);

    List<Cow> getAll();
}