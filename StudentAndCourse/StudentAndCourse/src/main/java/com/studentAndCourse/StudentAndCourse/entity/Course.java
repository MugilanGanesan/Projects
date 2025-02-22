package com.studentAndCourse.StudentAndCourse.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    
    private String courseName;
    private String courseDuration;
    private Integer courseFees;
    
    @ManyToMany(mappedBy = "courses")
    @JsonBackReference  // Prevents infinite recursion
    private Set<Student> students;
    
	public Course() {
		
	}

	public Course(Integer courseId, String courseName, String courseDuration, Integer courseFees,
			Set<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
		this.students = students;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Integer getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(Integer courseFees) {
		this.courseFees = courseFees;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", courseFees=" + courseFees + ", students=" + students + "]";
	}

	
}
