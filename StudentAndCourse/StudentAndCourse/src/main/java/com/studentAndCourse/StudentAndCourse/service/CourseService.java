package com.studentAndCourse.StudentAndCourse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentAndCourse.StudentAndCourse.dto.CourseDTO;
import com.studentAndCourse.StudentAndCourse.dto.StudentDTO;
import com.studentAndCourse.StudentAndCourse.entity.Course;
import com.studentAndCourse.StudentAndCourse.entity.Student;
import com.studentAndCourse.StudentAndCourse.exception.CourseNotFoundException;
import com.studentAndCourse.StudentAndCourse.mapper.CourseMapper;
import com.studentAndCourse.StudentAndCourse.mapper.StudentMapper;
import com.studentAndCourse.StudentAndCourse.repository.CourseRepository;
import com.studentAndCourse.StudentAndCourse.repository.StudentRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * Get all courses
     */
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return courseMapper.toCourseDTOList(courses);
    }

    public CourseDTO getCourseById(Integer courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        CourseDTO courseDTO = courseMapper.toCourseDTO(course);

        // ✅ Ensure students list is not null
        if (courseDTO.getStudents() == null) {
            courseDTO.setStudents(new ArrayList<>());  // Initialize empty list to prevent null error
        } else {
            courseDTO.getStudents().forEach(studentDTO -> studentDTO.setCourses(null));
        }

        return courseDTO;
    }


//    public CourseDTO getCourseById(Integer courseId) {
//        Course course = courseRepo.findById(courseId)
//                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));
//        return courseMapper.toCourseDTO(course);
//    }

    public CourseDTO getByCourseName(String name) {
        Course course = courseRepo.findByCourseName(name)
                .orElseThrow(() -> new CourseNotFoundException("Course Not Found"));

        CourseDTO courseDTO = courseMapper.toCourseDTO(course);

        // ✅ Ensure students list is not null
        if (courseDTO.getStudents() == null) {
            courseDTO.setStudents(new ArrayList<>());  // Initialize empty list to prevent null error
        } else {
            courseDTO.getStudents().forEach(studentDTO -> studentDTO.setCourses(null));
        }

        return courseDTO;
    }

//    public CourseDTO getCourseByName(String name) {
//        Course course = courseRepo.findByCourseName(name)
//                .orElseThrow(() -> new CourseNotFoundException("Course not found with name: " + name));
//        return courseMapper.toCourseDTO(course);
//    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toCourseEntity(courseDTO);

        // ✅ If students exist in request, fetch them from DB
        if (courseDTO.getStudents() != null && !courseDTO.getStudents().isEmpty()) {
            Set<Student> students = courseDTO.getStudents().stream()
                .map(studentDTO -> studentRepo.findById(studentDTO.getStudentId()).orElse(null))
                .filter(student -> student != null) // Avoid null values if student not found
                .collect(Collectors.toSet());

            course.setStudents(students);
        }

        course = courseRepo.save(course);
        return courseMapper.toCourseDTO(course);
    }

    /**
     * Update a course
     */
    public CourseDTO updateCourse(Integer id, CourseDTO courseDTO) {
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));

        existingCourse.setCourseName(courseDTO.getCourseName());
        existingCourse.setCourseDuration(courseDTO.getCourseDuration());
        existingCourse.setCourseFees(courseDTO.getCourseFees());

        // ✅ If students exist in request, fetch them from DB
        if (courseDTO.getStudents() != null && !courseDTO.getStudents().isEmpty()) {
            Set<Student> students = courseDTO.getStudents().stream()
                .map(studentDTO -> studentRepo.findById(studentDTO.getStudentId()).orElse(null))
                .filter(student -> student != null)
                .collect(Collectors.toSet());

            existingCourse.setStudents(students);
        }

        Course updatedCourse = courseRepo.save(existingCourse);
        return courseMapper.toCourseDTO(updatedCourse);
    }

    /**
     * Delete a course by ID
     */
    public void deleteCourse(Integer id) {
        courseRepo.deleteById(id);
    }

    /**
     * Convert Course entity to CourseDTO
     */
    public CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setCourseDuration(course.getCourseDuration());
        dto.setCourseFees(course.getCourseFees());

        // ✅ Convert Student Entities to StudentDTOs
        List<StudentDTO> studentDTOs = new ArrayList<>(course.getStudents().stream().map(student -> {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setStudentName(student.getStudentName());
            studentDTO.setStudentEmail(student.getStudentEmail());
            studentDTO.setStudentMobile(student.getStudentMobile());
            return studentDTO;
        }).toList()); // ✅ Convert Stream to List instead of Set

        dto.setStudents(studentDTOs); // ✅ Assign directly without casting

        return dto;
    }
    }