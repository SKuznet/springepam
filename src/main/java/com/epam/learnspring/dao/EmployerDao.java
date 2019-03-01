package com.epam.learnspring.dao;

import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.util.EmployerRequest;

public interface EmployerDao extends BasicDao<Employer> {

    Employer update(EmployerRequest employerRequest);
}
