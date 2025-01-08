package com.StudentAndCourse.Consumer.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.StudentAndCourse.Consumer.Entity.SalemStudents;


@Repository
public interface ConsumerRepository extends JpaRepository<SalemStudents, Integer>{

	Optional<SalemStudents> findByStudentName(String name);
	
	Optional<SalemStudents> findByStudentMobile(String mobile);
	
	//@Query("SELECT s FROM SalemStudents s WHERE s.course.id = :courseId")
	List<SalemStudents> findSalemStudentsByCourseId(@Param("courseId") Integer courseId);
}
