package com.ptonev.feeder.cv.service.interfaces;

import com.ptonev.feeder.cv.entity.EducationUnit;

import java.util.List;

public interface IEducationUnitService {
    List<EducationUnit> findAll();
    EducationUnit save(EducationUnit educationUnit);
}
