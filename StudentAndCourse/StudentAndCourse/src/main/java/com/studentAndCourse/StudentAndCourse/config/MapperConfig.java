package com.studentAndCourse.StudentAndCourse.config;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studentAndCourse.StudentAndCourse.mapper.CourseMapper;
import com.studentAndCourse.StudentAndCourse.mapper.StudentMapper;

@Configuration
public class MapperConfig {
    
	  @Bean
	    public StudentMapper studentMapper() {
	        return Mappers.getMapper(StudentMapper.class);
	    }

	    @Bean
	    public CourseMapper courseMapper() {
	        return Mappers.getMapper(CourseMapper.class);
	    }
}

