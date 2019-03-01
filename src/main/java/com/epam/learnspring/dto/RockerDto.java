package com.epam.learnspring.dto;

import com.epam.learnspring.entity.City;
import com.epam.learnspring.entity.Rocker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RockerDto {

    private Long id;
    private String name;
    private String title;
    private List<CityDto> cityDtoList = new ArrayList<>();

    public RockerDto getRockerDtoFromRocker(Rocker rocker) {
        RockerDto rockerDto = new RockerDto();
        rockerDto.setName(rocker.getName());
        rockerDto.setId(rocker.getId());
        rockerDto.setTitle(rocker.getGenre());

        List<CityDto> cityDtos = new ArrayList<>();
        for (City city : rocker.getCityList()) {
            CityDto cityDto = new CityDto();
            cityDto.setId(city.getId());
            cityDto.setModel(city.getType());
            cityDto.setYear(city.getYear());
            cityDtos.add(cityDto);
        }

        rockerDto.setCityDtoList(cityDtos);

        return rockerDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CityDto> getCityDtoList() {
        return cityDtoList;
    }

    public void setCityDtoList(List<CityDto> cityDtoList) {
        this.cityDtoList = cityDtoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
