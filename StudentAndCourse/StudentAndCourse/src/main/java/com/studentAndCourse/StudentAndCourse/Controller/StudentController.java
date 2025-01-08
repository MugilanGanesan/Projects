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

import com.studentAndCourse.StudentAndCourse.Entity.Student;
import com.studentAndCourse.StudentAndCourse.Service.CourseService;
import com.studentAndCourse.StudentAndCourse.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	    @GetMapping("/allstudents")
	    public ResponseEntity<List<Student>> getAllStudent(){
	    	List<Student> all=   studentService.getAllStudents();
	    	return new ResponseEntity<List<Student>>(all, HttpStatus.OK);
	    	
	    }
	
	@GetMapping("/studentid/{studentid}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentid)
	{
		Optional<Student> studId = studentService.getStudentById(studentid);
		Student stuid = studId.get();
		return new ResponseEntity<Student>(stuid,HttpStatus.OK);
	}
	
	@GetMapping("/studentname/{studentname}")
	public ResponseEntity<Student> getStudentByName(@PathVariable String studentname){
		
		   Optional<Student> studName=  studentService.getStudentByName(studentname);
		    Student stuname= studName.get();
		    return new ResponseEntity<Student>(stuname,HttpStatus.OK);
		
	}
	
	@GetMapping("/mobile/{mobile}")
	public ResponseEntity<Student> getStudentByMobile(@PathVariable String mobile){
		Student stumobile=studentService.getStudentByMobile(mobile);
		return new ResponseEntity<Student>(stumobile,HttpStatus.OK);
	}
	
    
    @GetMapping("/courseid/{courseId}")
    public ResponseEntity<List<Student>> getStudentByCourseId(@PathVariable Integer courseId){
    	List<Student> stucourse = studentService.getStudentByCourseId(courseId);
    	return new ResponseEntity<List<Student>>(stucourse, HttpStatus.OK);
    	
    }
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		Student addstudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(addstudent,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student)
	{
		Student updatestudent = studentService.updateStudent(id, student);
		return new ResponseEntity<Student>(updatestudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
	{
		String response = studentService.deleteStudent(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
