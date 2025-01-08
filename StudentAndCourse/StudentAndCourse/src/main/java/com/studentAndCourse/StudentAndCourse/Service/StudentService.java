package com.studentAndCourse.StudentAndCourse.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentAndCourse.StudentAndCourse.Entity.Student;
import com.studentAndCourse.StudentAndCourse.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	public Optional<Student> getStudentById(Integer id)
	{
		return studentRepository.findById(id);
	}
	
	public Optional<Student> getStudentByName(String name)
	{
		return studentRepository.findByStudentName(name);
	}
	
	public Student getStudentByMobile(String mobile)
	{
		Optional<Student> stuMobile= studentRepository.findByStudentMobile(mobile);
		Student stumobile=stuMobile.get();
		return stumobile;
	}
	
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	public Student addStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Integer id,Student student)
	{
		Optional<Student> stuUpdate = studentRepository.findById(id);
		if(stuUpdate.isPresent())
		{
			Student stud=stuUpdate.get();
			if(student.getStudentName()!=null)
			{
				stud.setStudentName(student.getStudentName());
			}
//			else {
//				stud.setStudentName(stud.getStudentName());
//			}
			
			
			if(student.getStudentMobile()!=null) {
				stud.setStudentMobile(student.getStudentMobile());
			}
//			else {
//				stud.setStudentMobile(stud.getStudentMobile());
//			}
			
			if(student.getStudentEmail()!=null) {
				stud.setStudentEmail(student.getStudentEmail());
			}
//			else {
//				stud.setStudentEmail(stud.getStudentEmail());
//			}
			if(student.getCourse()!=null) {
				stud.setCourse(student.getCourse());
			}
			return studentRepository.save(stud);
		}else {
			throw new EntityNotFoundException("The Student Id"+id+"is Not Available");
		}
		
	}
	
	public List<Student> getStudentByCourseId(Integer courseId)
	{
		return studentRepository.findStudentsByCourseId(courseId);
		
	}
	
	public String deleteStudent(Integer id)
	{
		studentRepository.deleteById(id);
		return "Deleted successfully";
	}
}
