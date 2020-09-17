package com.ptonev.feeder.cv.service.interfaces;

import com.ptonev.feeder.cv.entity.Employment;

import java.util.List;

public interface IEmploymentService {
    List<Employment> findAll();
    Employment save(Employment employment);
}
