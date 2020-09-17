package com.ptonev.feeder.cv.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.reposotory.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationResolver implements GraphQLQueryResolver {

    @Autowired
    private EducationRepository educationRepository;

    public Iterable<Education> findAllEducations() {
        return educationRepository.findAll();
    }

    public Long countEducations() {
        return educationRepository.count();
    }
}
