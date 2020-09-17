package com.ptonev.feeder.cv.controller;

import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.reposotory.EducationRepository;
import com.ptonev.feeder.cv.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/educations")
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private EducationService educationService;

    @GetMapping(
            path = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<List<Education>> list() {
        try {
            List<Education> entities = (List<Education>) educationRepository.findAll();
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
    public ResponseEntity<Education> get(@PathVariable UUID id) {
        try {
            Optional<Education> data = educationRepository.findById(id);

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
    public ResponseEntity<Education> create(@RequestBody Education inputEntity) {
        try {
            Education entity = new Education();
            entity.setEducationUnitId(inputEntity.getEducationUnitId());
            entity.setStartAt(inputEntity.getStartAt());
            entity.setEndAt(inputEntity.getEndAt());
            entity = educationRepository.save(entity);

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
    public ResponseEntity<Education> update(@PathVariable UUID id, @RequestBody Education inputEntity) {
        try {
            Optional<Education> data = educationRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Education entity = data.get();
            entity.setEducationUnitId(inputEntity.getEducationUnitId());
            entity.setStartAt(inputEntity.getStartAt());
            entity.setEndAt(inputEntity.getEndAt());
            entity = educationRepository.save(entity);

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
    public ResponseEntity<Education> delete(@PathVariable UUID id) {
        try {
            Optional<Education> data = educationRepository.findById(id);

            if (data.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            educationRepository.deleteById(id);

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
