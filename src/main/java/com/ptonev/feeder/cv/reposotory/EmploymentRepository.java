package com.ptonev.feeder.cv.reposotory;

import com.ptonev.feeder.cv.entity.Employment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmploymentRepository extends CrudRepository<Employment, UUID> {

}
