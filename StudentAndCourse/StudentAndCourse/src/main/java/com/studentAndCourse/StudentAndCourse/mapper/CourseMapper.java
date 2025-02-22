package com.studentAndCourse.StudentAndCourse.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.studentAndCourse.StudentAndCourse.dto.CourseDTO;
import com.studentAndCourse.StudentAndCourse.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	
    CourseDTO toCourseDTO(Course course);
    
    Course toCourseEntity(CourseDTO courseDTO);
    
    List<CourseDTO> toCourseDTOList(List<Course> courses);
}