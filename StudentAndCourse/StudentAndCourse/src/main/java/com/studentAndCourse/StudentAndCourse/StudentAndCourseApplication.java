package com.studentAndCourse.StudentAndCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.studentAndCourse.StudentAndCourse.entity")
public class StudentAndCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAndCourseApplication.class, args);
	}

}
