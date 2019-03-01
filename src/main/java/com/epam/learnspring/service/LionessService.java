package com.epam.learnspring.service;

import com.epam.learnspring.entity.Lioness;

import java.util.List;

public interface LionessService {
    Lioness add(Lioness lioness);

    Lioness update(Lioness lioness);

    Lioness delete(Long id);

    Lioness getLionessById(Long id);

    List<Lioness> getAll();
}