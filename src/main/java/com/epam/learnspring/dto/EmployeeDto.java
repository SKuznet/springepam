package com.epam.learnspring.dto;

import com.epam.learnspring.entity.Car;
import com.epam.learnspring.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDto {

    private Long id;
    private String name;
    private String title;
    private List<CarDto> carDtoList = new ArrayList<>();

    public EmployeeDto getEmployeeDtoFromEmployee(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setId(employee.getId());
        employeeDto.setTitle(employee.getTitle());

        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : employee.getCarList()) {
            CarDto carDto = new CarDto();
            carDto.setId(car.getId());
            carDto.setModel(car.getModel());
            carDto.setYear(car.getYear());
            carDtos.add(carDto);
        }

        employeeDto.setCarDtoList(carDtos);

        return employeeDto;
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

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }

    public void setCarDtoList(List<CarDto> carDtoList) {
        this.carDtoList = carDtoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
