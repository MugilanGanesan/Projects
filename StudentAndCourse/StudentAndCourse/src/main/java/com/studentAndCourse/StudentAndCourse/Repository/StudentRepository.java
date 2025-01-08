package com.studentAndCourse.StudentAndCourse.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentAndCourse.StudentAndCourse.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Optional<Student> findByStudentName(String name);
	
	Optional<Student> findByStudentMobile(String mobile);
	
	@Query("SELECT s FROM Student s WHERE s.course.id = :courseId")
	List<Student> findStudentsByCourseId(@Param("courseId") Integer courseId);

}
