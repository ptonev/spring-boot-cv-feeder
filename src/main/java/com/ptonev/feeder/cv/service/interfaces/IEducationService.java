package com.ptonev.feeder.cv.service.interfaces;

import com.ptonev.feeder.cv.entity.Education;

import java.util.List;

public interface IEducationService {
    List<Education> findAll();
    Education save(Education education);
}
