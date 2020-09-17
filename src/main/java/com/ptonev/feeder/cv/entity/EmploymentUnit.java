package com.ptonev.feeder.cv.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "employment_units")
public class EmploymentUnit {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            unique = true,
            nullable = false,
            updatable = false
    )
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnoreProperties("employmentUnit")
    @OneToMany(mappedBy = "employmentUnit", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Employment> employments = new ArrayList<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Version
    private LocalDateTime updatedAt;

    public EmploymentUnit() {
    }

    public EmploymentUnit(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }

    public void addEmployment(Employment employment) {
        employments.add(employment);
        employment.setEmploymentUnit(this);
    }

    public void removeEmployment(Employment employment) {
        employments.remove(employment);
        employment.setEmploymentUnit(null);
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmploymentUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
