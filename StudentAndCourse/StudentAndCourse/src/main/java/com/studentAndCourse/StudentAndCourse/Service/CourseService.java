package com.studentAndCourse.StudentAndCourse.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentAndCourse.StudentAndCourse.Entity.Course;
import com.studentAndCourse.StudentAndCourse.Entity.Student;
import com.studentAndCourse.StudentAndCourse.Repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {

	@Autowired
   public CourseRepository courseRepo;
	
	public Optional<Course> getCourseById(Integer id) {
	
		return courseRepo.findById(id);
	}
	
	public Optional<Course> getByCourseName(String name){
		return courseRepo.findByCourseName(name);
	}
	
	public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }
	
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public Course updateCourse(Integer id, Course course) {
		
	Optional<Course> updateCourse= 	courseRepo.findById(id);
	
	if(updateCourse.isPresent()) {
		Course repoCourse=updateCourse.get();
		
		if(course.getCourseName()!=null) {
			repoCourse.setCourseName(course.getCourseName());
		}
		if(course.getCourseDuration()!=null) {
			repoCourse.setCourseDuration(course.getCourseDuration());
		}
		if(course.getCourseFees()!=null) {
			repoCourse.setCourseFees(course.getCourseFees());
		}
		return courseRepo.save(repoCourse);
	}
	else {
		throw new EntityNotFoundException("This Id "+id+" Not Available");
	}
	
	}
	
	public void deleteCourse(Integer id) {
		courseRepo.deleteById(id);
	}
}
