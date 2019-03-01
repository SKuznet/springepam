package com.epam.learnspring.services.impl;

import com.epam.learnspring.dao.LaboratoryDao;
import com.epam.learnspring.dao.dto.LaboratoryDto;
import com.epam.learnspring.entity.Laboratory;
import com.epam.learnspring.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {
    private final LaboratoryDao laboratoryDao;
    private final LaboratoryDto laboratoryDto;

    @Autowired
    public LaboratoryServiceImpl(LaboratoryDao laboratoryDao, LaboratoryDto laboratoryDto) {
        this.laboratoryDao = laboratoryDao;
        this.laboratoryDto = laboratoryDto;
    }

    @Override
    public Laboratory add(Laboratory laboratoty) {
        return laboratoryDao.add(laboratoty);
    }

    @Override
    public Laboratory update(Laboratory laboratoty) {
        return laboratoryDao.update(laboratoty);
    }

    @Override
    public Laboratory delete(long id) {
        return laboratoryDao.delete(laboratoryDao.getById(id));
    }

    @Override
    public LaboratoryDto getUserById(long id) {
        return laboratoryDto.getLaboratoryDtoFromLaboratory(laboratoryDao.getById(id));
    }

    @Override
    public List<Laboratory> getAllUsers() {
        return laboratoryDao.getAll();
    }
}
