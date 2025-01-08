package com.studentAndCourse.StudentAndCourse.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentAndCourse.StudentAndCourse.Entity.Course;
import com.studentAndCourse.StudentAndCourse.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	public CourseService courseService;
	
	@GetMapping("/courseid/{courseid}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer courseid){
		Optional<Course> courseId =courseService.getCourseById(courseid);
		Course cor1=courseId.get();
		return new ResponseEntity<Course> (cor1, HttpStatus.OK);
	}
	
	@GetMapping("/coursename/{coursename}")
	public ResponseEntity<Course> getCourseByName(@PathVariable String coursename){
		Optional<Course> courseName=courseService.getByCourseName(coursename);
		Course cor2=courseName.get();
		return new ResponseEntity<Course>(cor2, HttpStatus.OK);
	} 
	
	@GetMapping("/allcourse")
	public List<Course> getAllCourse(){	
		return courseService.getAllCourse();
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		Course addcourse=courseService.addCourse(course);
		return new ResponseEntity<Course> (addcourse, HttpStatus.OK);
	}
	
	@PutMapping("/updatecourse/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody Course course){
		Course updatecourse=courseService.updateCourse(id, course);
		return new ResponseEntity<Course> (updatecourse, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecourse/{id}")
	public void deleteCourse(@PathVariable Integer id){
		
	 courseService.deleteCourse(id);
	}
	
}
