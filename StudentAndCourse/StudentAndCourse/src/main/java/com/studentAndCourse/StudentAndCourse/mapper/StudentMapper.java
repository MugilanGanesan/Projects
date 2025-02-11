package com.studentAndCourse.StudentAndCourse.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.studentAndCourse.StudentAndCourse.dto.CourseDTO;
import com.studentAndCourse.StudentAndCourse.dto.StudentDTO;
import com.studentAndCourse.StudentAndCourse.entity.Course;
import com.studentAndCourse.StudentAndCourse.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	
	
	
    StudentDTO toStudentDTO(Student student);
    
    Student toStudentEntity(StudentDTO studentDTO);
    
    List<StudentDTO> toStudentDTOList(List<Student> students);
}