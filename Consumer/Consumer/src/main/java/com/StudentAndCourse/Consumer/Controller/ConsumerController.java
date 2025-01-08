package com.StudentAndCourse.Consumer.Controller;

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

import com.StudentAndCourse.Consumer.Entity.SalemStudents;
import com.StudentAndCourse.Consumer.Service.ConsumerService;


@RestController
@RequestMapping("/salemstudents")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	 @GetMapping("/allstudentswithid")
	    public List<SalemStudents> getAllStudentsWithCourses() {
	        return consumerService.getAllStudentsWithCourses();
	 }

	 @GetMapping("/allcourse")
	    //http://localhost:8081/consumer/allcourse
	    public ResponseEntity<Object> allcourse(){
	    	return consumerService.allCourse();
	    }
	 
	 @GetMapping("/allstudents")
	 //http://localhost:8081/consumer/allstudents
	 public ResponseEntity<List<SalemStudents>> allstudents(){
		 List<SalemStudents> salemstudents = consumerService.getAllStudents();
		 return new ResponseEntity<List<SalemStudents>>(salemstudents, HttpStatus.OK);
	 }
	 
	 @GetMapping("/studentid/{studentid}")
		public ResponseEntity<SalemStudents> getStudentById(@PathVariable Integer studentid)
		{
			Optional<SalemStudents> student = consumerService.getStudentById(studentid);
			SalemStudents studentId = student.get();
			return new ResponseEntity<SalemStudents>(studentId,HttpStatus.OK);
		}
		
		@GetMapping("/studentname/{studentname}")
		public ResponseEntity<SalemStudents> getStudentByName(@PathVariable String studentname){
			
			   Optional<SalemStudents> student=  consumerService.getStudentByName(studentname);
			   SalemStudents studentName= student.get();
			    return new ResponseEntity<SalemStudents>(studentName,HttpStatus.OK);
			
		}
		
		@GetMapping("/mobile/{mobile}")
		public ResponseEntity<SalemStudents> getStudentByMobile(@PathVariable String mobile){
			Optional<SalemStudents> student = consumerService.getStudentByMobile(mobile);
			SalemStudents studentMob = student.get();
			return new ResponseEntity<SalemStudents>(studentMob,HttpStatus.OK);
		}
		
	    
	    
	    @GetMapping("/course/{courseId}")
	    public ResponseEntity<List<SalemStudents>> getStudentByCourseId(@PathVariable Integer courseId){
	    	List<SalemStudents> courseid = consumerService.getStudentByCourseId(courseId);
	    	return new ResponseEntity<List<SalemStudents>>(courseid, HttpStatus.OK);
	    	
	    }
		
		@PostMapping("/addstudent")
		public ResponseEntity<SalemStudents> addStudent(@RequestBody SalemStudents student)
		{
			SalemStudents addstudent = consumerService.addStudents(student);
			return new ResponseEntity<SalemStudents>(addstudent,HttpStatus.CREATED);
		}
		
		@PutMapping("/updatestudent/{id}")
		public ResponseEntity<SalemStudents> updateStudent(@PathVariable Integer id,@RequestBody SalemStudents student)
		{
			SalemStudents studentupdate = consumerService.updateStudent(id, student);
			return new ResponseEntity<SalemStudents>(studentupdate,HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
		{
			String response = consumerService.deleteStudent(id);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
}


