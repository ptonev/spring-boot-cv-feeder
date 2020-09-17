package com.ptonev.feeder.cv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptonev.feeder.cv.entity.Education;
import com.ptonev.feeder.cv.entity.EducationUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class CvFeederApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void givenBidirectionRelation_whenSerializing_thenException() throws JsonProcessingException {

		EducationUnit educationUnit = new EducationUnit();
		educationUnit.setName("@TEST - UniBUT");

		Education education = new Education();
		education.setStartAt(new Date());
		education.setEndAt(new Date());
		education.setEducationUnit(educationUnit);

		new ObjectMapper().writeValueAsString(education);
	}
}
