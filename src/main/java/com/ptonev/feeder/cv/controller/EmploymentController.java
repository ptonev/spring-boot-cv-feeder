package com.ptonev.feeder.cv.controller;

import com.ptonev.feeder.cv.entity.Employment;
import com.ptonev.feeder.cv.reposotory.EmploymentRepository;
import com.ptonev.feeder.cv.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employments")
public class EmploymentController {

    @Autowired
    private EmploymentRepository employmentRepository;

    @Autowired
    private EmploymentService employmentService;

    @GetMapping(
            path = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<List<Employment>> list() {
        try {
            List<Employment> entities = (List<Employment>) employmentRepository.findAll();
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
    public ResponseEntity<Employment> get(@PathVariable UUID id) {
        try {
            Optional<Employment> data = employmentRepository.findById(id);

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
    public ResponseEntity<Employment> create(@RequestBody Employment inputEntity) {
        try {
            Employment entity = new Employment();
            entity.setEmploymentUnitId(inputEntity.getEmploymentUnitId());
            entity.setStartAt(inputEntity.getStartAt());
            entity.setEndAt(inputEntity.getEndAt());
            entity = employmentRepository.save(entity);

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
    public ResponseEntity<Employment> update(@PathVariable UUID id, @RequestBody Employment inputEntity) {
        try {
            Optional<Employment> data = employmentRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Employment entity = data.get();
            entity.setEmploymentUnitId(inputEntity.getEmploymentUnitId());
            entity.setStartAt(inputEntity.getStartAt());
            entity.setEndAt(inputEntity.getEndAt());
            entity = employmentRepository.save(entity);

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
    public ResponseEntity<Employment> delete(@PathVariable UUID id) {
        try {
            Optional<Employment> data = employmentRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            employmentRepository.deleteById(id);

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
