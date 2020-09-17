package com.ptonev.feeder.cv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EducationUnitInput {
    @Column(name = "name", nullable = false)
    private String name;

    private List<Education> educations = new ArrayList<>();

    public EducationUnitInput() {
    }

    public EducationUnitInput(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @Override
    public String toString() {
        return "EducationUnit{" +
                ", name='" + name + '\'' +
                '}';
    }
}
