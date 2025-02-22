package com.studentAndCourse.StudentAndCourse.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentAndCourse.StudentAndCourse.dto.CourseDTO;
import com.studentAndCourse.StudentAndCourse.entity.Course;
import com.studentAndCourse.StudentAndCourse.repository.CourseRepository;
import com.studentAndCourse.StudentAndCourse.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	 @Autowired
	    private CourseService courseService;
	 
	 @Autowired
	 private CourseRepository courseRepo;

	    @GetMapping("/courseid/{courseid}")
	    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer courseid) {
	        CourseDTO courseDTO = courseService.getCourseById(courseid);
	        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
	    }
	
	    @GetMapping("/coursename/{coursename}")
	    public ResponseEntity<CourseDTO> getCourseByName(@PathVariable String coursename) {
	        CourseDTO courseDTO = courseService.getByCourseName(coursename);
	        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
	    }

	    @GetMapping("/allcourses")
	    public ResponseEntity<List<CourseDTO>> getAllCourses() {
	        List<Course> courses = courseRepo.findAll();
	        List<CourseDTO> courseDTOs = courses.stream()
	                .map(courseService::convertToDTO)
	                .collect(Collectors.toList());

	        return new ResponseEntity<>(courseDTOs,HttpStatus.OK);
	    }

	    @PostMapping(value = "/addcourse", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO course) {
	        CourseDTO addedCourse = courseService.addCourse(course);
	        return new ResponseEntity<>(addedCourse, HttpStatus.CREATED);
	    }

	    @PutMapping("/updatecourse/{id}")
	    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Integer id, @RequestBody CourseDTO course) {
	        CourseDTO updatedCourse = courseService.updateCourse(id, course);
	        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
	    }

	    @DeleteMapping("/deletecourse/{id}")
	    public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
	        courseService.deleteCourse(id);
	        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
	    }
	
}
