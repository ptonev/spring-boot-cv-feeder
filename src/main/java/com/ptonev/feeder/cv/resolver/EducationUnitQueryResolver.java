package com.ptonev.feeder.cv.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ptonev.feeder.cv.entity.EducationUnit;
import com.ptonev.feeder.cv.reposotory.EducationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationUnitQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private EducationUnitRepository educationUnitRepository;

    public Iterable<EducationUnit> findAllEducationUnits() {
        return educationUnitRepository.findAll();
    }

    public Long countEducationUnits() {
        return educationUnitRepository.count();
    }
}
