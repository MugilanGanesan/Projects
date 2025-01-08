package com.studentAndCourse.StudentAndCourse.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentAndCourse.StudentAndCourse.Entity.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	Optional<Course> findByCourseName(String name);
	
	
}
