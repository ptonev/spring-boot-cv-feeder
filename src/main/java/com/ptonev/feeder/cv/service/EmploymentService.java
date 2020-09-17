package com.ptonev.feeder.cv.service;

import com.ptonev.feeder.cv.entity.Employment;
import com.ptonev.feeder.cv.reposotory.EmploymentRepository;
import com.ptonev.feeder.cv.service.interfaces.IEmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentService implements IEmploymentService {
    @Autowired
    private EmploymentRepository employmentRepository;

    @Override
    public List<Employment> findAll() {
        return (List<Employment>) employmentRepository.findAll();
    }

    @Override
    public Employment save(Employment employment) {
        return employmentRepository.save(employment);
    }
}
