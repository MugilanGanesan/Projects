package com.studentAndCourse.StudentAndCourse.controller;

import java.util.List;

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
import com.studentAndCourse.StudentAndCourse.dto.StudentDTO;
import com.studentAndCourse.StudentAndCourse.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	 @Autowired
	    private StudentService studentService;
	 
	    @GetMapping("/allstudents")
	    public ResponseEntity<List<StudentDTO>> getAllStudents() {
	        List<StudentDTO> students = studentService.getAllStudents();
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }

	    @GetMapping("/studentid/{studentid}")
	    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) {
	    	StudentDTO student=studentService.getStudentById(id);
	        return new ResponseEntity<>(student,HttpStatus.OK);
	    }

	    @GetMapping("/studentname/{name}")
	    public ResponseEntity<StudentDTO> getStudentByName(@PathVariable String name) {
	    	StudentDTO student=studentService.getStudentByName(name);
	        return new ResponseEntity<>(student,HttpStatus.OK);
	    }


	    @GetMapping("/mobile/{mobile}")
	    public ResponseEntity<StudentDTO> getStudentByMobile(@PathVariable String mobile) {
	        StudentDTO student = studentService.getStudentByMobile(mobile);
	        return new ResponseEntity<>(student, HttpStatus.OK);
	    }

	    
	    @PostMapping(value = "/addstudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
	    	StudentDTO addedStudent = studentService.addStudent(studentDTO);
	        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
	    }
	  

	    @PutMapping("/updatestudent/{id}")
	    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO student) {
	        StudentDTO updatedStudent = studentService.updateStudent(id, student);
	        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
	        studentService.deleteStudent(id);
	        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
	    }
	
}
