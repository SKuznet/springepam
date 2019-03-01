package com.epam.learnspring.dao.dto;

import com.epam.learnspring.entity.Laboratory;
import com.epam.learnspring.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryDto {
    private long id;
    private String name;
    private User chief;

    public LaboratoryDto getLaboratoryDtoFromLaboratory(Laboratory laboratory) {
        LaboratoryDto laboratoryDto = new LaboratoryDto();
        laboratoryDto.setName(laboratory.getName());
        laboratoryDto.setId(laboratory.getId());
        laboratoryDto.setChief(laboratory.getChief());

        return laboratoryDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getChief() {
        return chief;
    }

    public void setChief(User chief) {
        this.chief = chief;
    }
}
