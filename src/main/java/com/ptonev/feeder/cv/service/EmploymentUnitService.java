package com.ptonev.feeder.cv.service;

import com.ptonev.feeder.cv.entity.EmploymentUnit;
import com.ptonev.feeder.cv.reposotory.EmploymentUnitRepository;
import com.ptonev.feeder.cv.service.interfaces.IEmploymentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentUnitService implements IEmploymentUnitService {
    @Autowired
    private EmploymentUnitRepository employmentUnitRepository;

    @Override
    public List<EmploymentUnit> findAll() {
        return (List<EmploymentUnit>) employmentUnitRepository.findAll();
    }

    @Override
    public EmploymentUnit save(EmploymentUnit employmentUnit) {
        return employmentUnitRepository.save(employmentUnit);
    }
}
