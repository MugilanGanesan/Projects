package com.studentAndCourse.StudentAndCourse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentAndCourse.StudentAndCourse.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Optional<Student> findById(Integer studentId);
	
	    Optional<Student> findByStudentMobile(String mobile);
	    Optional<Student> findByStudentName(String name);
}
