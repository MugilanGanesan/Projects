package com.StudentAndCourse.Consumer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.StudentAndCourse.Consumer.Entity.Course;
import com.StudentAndCourse.Consumer.Entity.SalemStudents;
import com.StudentAndCourse.Consumer.Repository.ConsumerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsumerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ConsumerRepository consumerRepo;

	
//	private final String studentUrl="http://localhost:8081/student";
	private final String courseUrl="http://localhost:8081/course";
	
	public ResponseEntity<Object> allCourse(){
		
		Object object= restTemplate.getForObject(courseUrl+"/allcourse", Object.class);
		
		return ResponseEntity.ok(object);
		
	}
	
	public List<SalemStudents> getAllStudents() {
        return consumerRepo.findAll();
    }
	
	public Optional<SalemStudents> getStudentById(Integer id)
	{
		return consumerRepo.findById(id);
	}
	
	
	public Optional<SalemStudents> getStudentByName(String name)
	{
		return consumerRepo.findByStudentName(name);
	}
	
	public Optional<SalemStudents> getStudentByMobile(String mobile)
	{
		return consumerRepo.findByStudentMobile(mobile);
	}
	
	
	public SalemStudents addStudents(SalemStudents students) {
		return consumerRepo.save(students);
	}
	
	public SalemStudents updateStudent(Integer id,SalemStudents salemstudent)
	{
		Optional<SalemStudents> studentupdate = consumerRepo.findById(id);
		if(studentupdate.isPresent())
		{
			SalemStudents stud=studentupdate.get();
			if(salemstudent.getStudentName()!=null)
			{
				stud.setStudentName(salemstudent.getStudentName());
			}
//			else {
//				stud.setStudentName(stud.getStudentName());
//			}
			
			
			if(salemstudent.getStudentMobile()!=null) {
				stud.setStudentMobile(salemstudent.getStudentMobile());
			}
//			else {
//				stud.setStudentMobile(stud.getStudentMobile());
//			}
			
			if(salemstudent.getStudentEmail()!=null) {
				stud.setStudentEmail(salemstudent.getStudentEmail());
			}
//			else {
//				stud.setStudentEmail(stud.getStudentEmail());
//			}
			return consumerRepo.save(stud);
		}else {
			throw new EntityNotFoundException("The Student Id"+id+"is Not Available");
		}
		
	}
	
	public List<SalemStudents> getStudentByCourseId(Integer courseId)
	{
		Object coursestudent=consumerRepo.findSalemStudentsByCourseId(courseId);
		return consumerRepo.findSalemStudentsByCourseId(courseId);
		
	}
	
	public String deleteStudent(Integer id)
	{
		consumerRepo.deleteById(id);
		return "Deleted successfully";
	}
	 
	 public ResponseEntity<Object> findByCourseName(String courseName) {
	        
	        Object coursename = restTemplate.getForObject(courseUrl + "/coursename/" + courseName, Object.class);

	       
	        return ResponseEntity.ok(coursename);
	    }

	 public List<SalemStudents> getAllStudentsWithCourses() {
	        List<SalemStudents> students = consumerRepo.findAll();
	        
	        for(SalemStudents student : students) {
	        	if (student.getCourseId() != null) {
	                String courses = courseUrl + "/courseid/"+student.getCourseId();
	                Course course = restTemplate.getForObject(courses, Course.class);
	                student.setCourse(course);
	            }
	        }

	        return students;
	    }
	 
}

