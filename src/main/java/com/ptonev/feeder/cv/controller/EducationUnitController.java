package com.ptonev.feeder.cv.controller;

import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.entity.EducationUnit;
import com.ptonev.feeder.cv.reposotory.EducationUnitRepository;
import com.ptonev.feeder.cv.service.EducationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/education-units")
public class EducationUnitController {

    @Autowired
    private EducationUnitRepository educationUnitRepository;

    @Autowired
    private EducationUnitService educationUnitService;

    @GetMapping(
            path = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<List<EducationUnit>> list() {
        try {
            List<EducationUnit> entities = (List<EducationUnit>) educationUnitRepository.findByOrderByNameAsc();
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(
            path = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EducationUnit> get(@PathVariable UUID id) {
        try {
            Optional<EducationUnit> data = educationUnitRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            path = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EducationUnit> create(@RequestBody EducationUnit inputEntity) {
        try {
            EducationUnit entity = new EducationUnit(inputEntity.getName());
            entity = educationUnitRepository.save(entity);

            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(
            path = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EducationUnit> update(@PathVariable UUID id, @RequestBody EducationUnit inputEntity) {
        try {
            Optional<EducationUnit> data = educationUnitRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            EducationUnit entity = data.get();
            entity.setName(inputEntity.getName());
            entity = educationUnitRepository.save(entity);

            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(
            path = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EducationUnit> delete(@PathVariable UUID id) {
        try {
            Optional<EducationUnit> data = educationUnitRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            educationUnitRepository.deleteById(id);

            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ping")
    public String test() {
        return "pong";
    }
}
