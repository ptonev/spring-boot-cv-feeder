package com.ptonev.feeder.cv.bootstrap;

import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.entity.EducationUnit;
import com.ptonev.feeder.cv.reposotory.EducationRepository;
import com.ptonev.feeder.cv.reposotory.EducationUnitRepository;
import com.ptonev.feeder.cv.reposotory.EmploymentRepository;
import com.ptonev.feeder.cv.reposotory.EmploymentUnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final EducationUnitRepository educationUnitRepository;
    private final EducationRepository educationRepository;
    private final EmploymentUnitRepository employmentUnitRepository;
    private final EmploymentRepository employmentRepository;

    public BootStrapData(EducationUnitRepository educationUnitRepository, EducationRepository educationRepository, EmploymentUnitRepository employmentUnitRepository, EmploymentRepository employmentRepository) {
        this.educationUnitRepository = educationUnitRepository;
        this.educationRepository = educationRepository;
        this.employmentUnitRepository = employmentUnitRepository;
        this.employmentRepository = employmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getName() + ": start.");

        Optional entity;

        //  Education Units
        entity = educationUnitRepository.findByName("OMG „AKAD. K. POPOV”");
        EducationUnit eduOMG = entity.isPresent()
                ? (EducationUnit) entity.get()
                : new EducationUnit("OMG „AKAD. K. POPOV”");
        educationUnitRepository.save(eduOMG);

        entity = educationUnitRepository.findByName("College „JOHN VINCENT ATANASOFF”");
        EducationUnit eduCollege = entity.isPresent()
                ? (EducationUnit) entity.get()
                : new EducationUnit("College „JOHN VINCENT ATANASOFF”");
        educationUnitRepository.save(eduCollege);

        entity = educationUnitRepository.findByName("UniBit");
        EducationUnit eduUniBit = entity.isPresent()
                ? (EducationUnit) entity.get()
                : new EducationUnit("UniBit");
        educationUnitRepository.save(eduUniBit);

        //  Educations
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        entity = educationRepository.findByEducationUnitId(eduOMG.getId());
        Education edOMG = entity.isPresent()
                ? (Education) entity.get()
                : new Education(
                        eduOMG.getId(),
                        dateFormat.parse("1990-09-15 00:00:00.000"),
                        dateFormat.parse("1991-05-24 23:59:59.000")
                );
        educationRepository.save(edOMG);

        entity = educationRepository.findByEducationUnitId(eduCollege.getId());
        Education edCollege = entity.isPresent()
                ? (Education) entity.get()
                : new Education(
                eduCollege.getId(),
                dateFormat.parse("1993-09-15 00:00:00.000"),
                dateFormat.parse("1996-07-31 23:59:59.000")
        );
        educationRepository.save(edCollege);

        entity = educationRepository.findByEducationUnitId(eduUniBit.getId());
        Education edUniBit = entity.isPresent()
                ? (Education) entity.get()
                : new Education(
                eduUniBit.getId(),
                dateFormat.parse("2015-09-15 00:00:00.000"),
                dateFormat.parse("2017-07-31 23:59:59.000")
        );
        educationRepository.save(edUniBit);

        System.out.println(this.getClass().getName() + ": end.");
    }
}
