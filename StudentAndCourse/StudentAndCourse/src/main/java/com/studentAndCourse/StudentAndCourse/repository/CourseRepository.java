package com.studentAndCourse.StudentAndCourse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentAndCourse.StudentAndCourse.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	 Optional<Course> findByCourseName(String courseName);
}
