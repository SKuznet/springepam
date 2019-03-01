package com.epam.learnspring.service.impl;

import com.epam.learnspring.dao.EmployerDao;
import com.epam.learnspring.entity.Employer;
import com.epam.learnspring.service.EmployerService;
import com.epam.learnspring.util.EmployerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    public EmployerDao employerDao;

    @Override
    public Employer add(Employer employer) {
        return employerDao.add(employer);
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.getAll();
    }

    @Override
    public Employer update(EmployerRequest employerRequest) {
        return employerDao.update(employerRequest);
    }
}
