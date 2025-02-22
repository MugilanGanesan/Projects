package com.studentAndCourse.StudentAndCourse.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentAndCourse.StudentAndCourse.dto.CourseDTO;
import com.studentAndCourse.StudentAndCourse.dto.StudentDTO;
import com.studentAndCourse.StudentAndCourse.entity.Course;
import com.studentAndCourse.StudentAndCourse.entity.Student;
import com.studentAndCourse.StudentAndCourse.exception.StudentNotFoundException;
import com.studentAndCourse.StudentAndCourse.mapper.StudentMapper;
import com.studentAndCourse.StudentAndCourse.repository.CourseRepository;
import com.studentAndCourse.StudentAndCourse.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	 private StudentMapper studentMapper;

	    
	 @Autowired
	    private StudentRepository studentRepo;

	    @Autowired
	    private CourseRepository courseRepo;

	    
	    public List<StudentDTO> getAllStudents() {
	        List<Student> students = studentRepo.findAll();
	        return studentMapper.toStudentDTOList(students);
	    }
	    public StudentDTO getStudentById(Integer id) {
	        Student student = studentRepo.findById(id)
	                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

	        return studentMapper.toStudentDTO(student);
	    }
	    
	    public StudentDTO convertToDTO(Student student) {
	        StudentDTO dto = new StudentDTO();
	        dto.setStudentId(student.getStudentId());
	        dto.setStudentName(student.getStudentName());
	        dto.setStudentEmail(student.getStudentEmail());
	        dto.setStudentMobile(student.getStudentMobile());

	        Set<CourseDTO> courseDTOs = student.getCourses().stream().map(course -> {
	            CourseDTO courseDTO = new CourseDTO();
	            courseDTO.setCourseId(course.getCourseId());
	            courseDTO.setCourseName(course.getCourseName());
	            courseDTO.setCourseDuration(course.getCourseDuration());
	            courseDTO.setCourseFees(course.getCourseFees());
	            return courseDTO;
	        }).collect(Collectors.toSet());

	        dto.setCourses((List<CourseDTO>) courseDTOs);
	        return dto;
	    }
	    
	    public StudentDTO getStudentByName(String name) {
	        Student student = studentRepo.findByStudentName(name)
	                .orElseThrow(() -> new StudentNotFoundException("Student not found with name: " + name));

	        return studentMapper.toStudentDTO(student);
	    }
	    

	    public StudentDTO getStudentByMobile(String mobile) {
	        Student student = studentRepo.findByStudentMobile(mobile)
	                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
	        return studentMapper.toStudentDTO(student);
	    }

	    public StudentDTO addStudent(StudentDTO studentDTO) {
	        Student student = studentMapper.toStudentEntity(studentDTO);

	        if (studentDTO.getCourses() != null && !studentDTO.getCourses().isEmpty()) {
	            Set<Course> courses = studentDTO.getCourses().stream()
	                .map(courseDTO -> courseRepo.findById(courseDTO.getCourseId()).orElse(null))
	                .filter(course -> course != null) 
	                .collect(Collectors.toSet());

	            student.setCourses(courses);
	        }

	        student = studentRepo.save(student);
	        return studentMapper.toStudentDTO(student);
	    }

	    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
	        Student existingStudent = studentRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student Not Found"));

	        existingStudent.setStudentName(studentDTO.getStudentName());
	        existingStudent.setStudentEmail(studentDTO.getStudentEmail());
	        existingStudent.setStudentMobile(studentDTO.getStudentMobile());


	        Student updatedStudent = studentRepo.save(existingStudent);
	        return studentMapper.toStudentDTO(updatedStudent);
	    }

	    public void deleteStudent(Integer id) {
	        studentRepo.deleteById(id);
	    }
}
