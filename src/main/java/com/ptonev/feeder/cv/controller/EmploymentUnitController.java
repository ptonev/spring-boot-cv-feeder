package com.ptonev.feeder.cv.controller;

import com.ptonev.feeder.cv.entity.EmploymentUnit;
import com.ptonev.feeder.cv.reposotory.EmploymentUnitRepository;
import com.ptonev.feeder.cv.service.EmploymentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employment-units")
public class EmploymentUnitController {

    @Autowired
    private EmploymentUnitRepository employmentUnitRepository;

    @Autowired
    private EmploymentUnitService employmentUnitService;

    @GetMapping(
            path = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<List<EmploymentUnit>> list() {
        try {
            List<EmploymentUnit> entities = (List<EmploymentUnit>) employmentUnitRepository.findByOrderByNameAsc();

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
    public ResponseEntity<EmploymentUnit> get(@PathVariable UUID id) {
        try {
            Optional<EmploymentUnit> data = employmentUnitRepository.findById(id);

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
    public ResponseEntity<EmploymentUnit> create(@RequestBody EmploymentUnit inputEntity) {
        try {
            EmploymentUnit entity = new EmploymentUnit(inputEntity.getName());
            entity = employmentUnitRepository.save(entity);

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
    public ResponseEntity<EmploymentUnit> update(@PathVariable UUID id, @RequestBody EmploymentUnit inputEntity) {
        try {
            Optional<EmploymentUnit> data = employmentUnitRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            EmploymentUnit entity = data.get();
            entity.setName(inputEntity.getName());
            entity = employmentUnitRepository.save(entity);

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
    public ResponseEntity<EmploymentUnit> delete(@PathVariable UUID id) {
        try {
            Optional<EmploymentUnit> data = employmentUnitRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            employmentUnitRepository.deleteById(id);

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
