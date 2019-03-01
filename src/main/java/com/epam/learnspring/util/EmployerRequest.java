package com.epam.learnspring.util;

import lombok.Data;

@Data
public class EmployerRequest {
    Long id;
    String name;
    Long employeeId;
}
