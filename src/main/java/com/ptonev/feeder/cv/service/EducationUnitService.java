package com.ptonev.feeder.cv.service;

import com.ptonev.feeder.cv.entity.EducationUnit;
import com.ptonev.feeder.cv.reposotory.EducationUnitRepository;
import com.ptonev.feeder.cv.service.interfaces.IEducationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationUnitService implements IEducationUnitService {
    @Autowired
    private EducationUnitRepository educationUnitRepository;

    @Override
    public List<EducationUnit> findAll() {
        return (List<EducationUnit>) educationUnitRepository.findAll();
    }

    @Override
    public EducationUnit save(EducationUnit educationUnit) {
        return educationUnitRepository.save(educationUnit);
    }
}
