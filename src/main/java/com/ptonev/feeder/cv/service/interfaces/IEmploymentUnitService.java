package com.ptonev.feeder.cv.service.interfaces;

import com.ptonev.feeder.cv.entity.EmploymentUnit;

import java.util.List;

public interface IEmploymentUnitService {
    List<EmploymentUnit> findAll();
    EmploymentUnit save(EmploymentUnit employmentUnit);
}
