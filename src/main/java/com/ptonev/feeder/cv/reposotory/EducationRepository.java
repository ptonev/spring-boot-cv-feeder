package com.ptonev.feeder.cv.reposotory;

import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.entity.EducationUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducationRepository extends CrudRepository<Education, UUID> {
    Optional<Education> findByEducationUnitId(UUID educationUnitId);
}
