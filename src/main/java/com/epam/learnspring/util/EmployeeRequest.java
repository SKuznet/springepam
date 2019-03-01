package com.epam.learnspring.util;

import lombok.Data;

@Data
public class EmployeeRequest {
    String name;
    String surname;
    Long employerId;
}
