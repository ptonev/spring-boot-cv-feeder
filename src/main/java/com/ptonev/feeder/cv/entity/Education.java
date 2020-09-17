package com.ptonev.feeder.cv.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "educations")
public class Education {
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

    @Column(name = "education_unit_id")
    private UUID educationUnitId;

    @JsonIgnoreProperties("educations")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "education_unit_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EducationUnit educationUnit;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_at")
    private Date startAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_at")
    private Date endAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Version
    private LocalDateTime updatedAt;

    public Education() {
    }

    public Education(UUID educationUnitId, Date startAt, Date endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.educationUnitId = educationUnitId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEducationUnitId() {
        return educationUnitId;
    }

    public void setEducationUnitId(UUID educationUnitId) {
        this.educationUnitId = educationUnitId;
    }

    public EducationUnit getEducationUnit() {
        return educationUnit;
    }

    public void setEducationUnit(EducationUnit educationUnit) {
        this.educationUnit = educationUnit;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
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
        return "Education{" +
                "id=" + id +
                ", educationUnit=" + educationUnit +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
