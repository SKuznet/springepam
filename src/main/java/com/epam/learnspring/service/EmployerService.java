package com.epam.learnspring.service;

import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.util.EmployerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployerService {
    Employer add(Employer employer);
    List<Employer> getAll();
    Employer update(EmployerRequest employerRequest);
}
