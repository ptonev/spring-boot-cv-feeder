package com.ptonev.feeder.cv.service;

import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.reposotory.EducationRepository;
import com.ptonev.feeder.cv.service.interfaces.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return (List<Education>) educationRepository.findAll();
    }

    @Override
    public Education save(Education education) {
        return educationRepository.save(education);
    }
}
