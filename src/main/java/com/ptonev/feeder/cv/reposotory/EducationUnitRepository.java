package com.ptonev.feeder.cv.reposotory;

import com.ptonev.feeder.cv.entity.EducationUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducationUnitRepository extends CrudRepository<EducationUnit, UUID> {
    Optional<EducationUnit> findByName(String name);

    List<EducationUnit> findByOrderByNameAsc();
    List<EducationUnit> findByOrderByNameDesc();
}
