package com.epam.learnspring.services;

import com.epam.learnspring.dao.dto.LaboratoryDto;
import com.epam.learnspring.entity.Laboratory;

import java.util.List;

public interface LaboratoryService {
    Laboratory add (Laboratory laboratoty);
    Laboratory update (Laboratory laboratoty);
    Laboratory delete (long id);
    LaboratoryDto getUserById (long id);
    List<Laboratory> getAllUsers();
}
