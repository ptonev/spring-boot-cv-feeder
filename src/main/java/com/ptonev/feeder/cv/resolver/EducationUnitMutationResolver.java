package com.ptonev.feeder.cv.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ptonev.feeder.cv.entity.EducationUnit;
import com.ptonev.feeder.cv.entity.EducationUnitInput;
import com.ptonev.feeder.cv.reposotory.EducationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationUnitMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private EducationUnitRepository educationUnitRepository;

    public EducationUnit createEducationUnit(EducationUnitInput educationUnitInput) {
        EducationUnit educationUnit = new EducationUnit();
        educationUnit.setName(educationUnitInput.getName());
        return educationUnitRepository.save(educationUnit);
    }

    public Boolean deleteEducationUnit(UUID id) {
        educationUnitRepository.deleteById(id);
//        try {
//        } catch (EmptyResultDataAccessException ex) {
//            throw new EducationUnitNotFoundException("The education unit was not found", id.toString());
//        }
        return true;
    }
}
