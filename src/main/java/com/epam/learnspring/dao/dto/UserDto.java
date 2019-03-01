package com.epam.learnspring.dao.dto;

import com.epam.learnspring.entity.Laboratory;
import com.epam.learnspring.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDto {
    private long id;
    private String name;
    private String position;
    private List<LaboratoryDto> laboratories;

    public UserDto getUserDtoFromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setPosition(user.getPosition());

        List<LaboratoryDto> laboratories = new ArrayList<>();
        for (Laboratory laboratory : user.getLaboratories()) {
            LaboratoryDto laboratoryDto = new LaboratoryDto();
            laboratoryDto.setId(laboratory.getId());
            laboratoryDto.setChief(laboratory.getChief());
            laboratoryDto.setName(laboratory.getName());
            laboratories.add(laboratoryDto);
        }
        userDto.setLaboratories(laboratories);

        return userDto;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<LaboratoryDto> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(List<LaboratoryDto> laboratories) {
        this.laboratories = laboratories;
    }
}
