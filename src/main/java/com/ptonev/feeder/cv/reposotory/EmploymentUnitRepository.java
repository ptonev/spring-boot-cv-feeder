package com.ptonev.feeder.cv.reposotory;

import com.ptonev.feeder.cv.entity.EmploymentUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmploymentUnitRepository extends CrudRepository<EmploymentUnit, UUID> {

    List<EmploymentUnit> findByOrderByNameAsc();

    List<EmploymentUnit> findByOrderByNameDesc();
}
