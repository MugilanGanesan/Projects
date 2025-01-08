package com.studentAndCourse.StudentAndCourse.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	
	 @Column(unique = true, nullable = false)
	private String courseName;
	
	 @Column(nullable = false)
	private String courseDuration;
	
	 @Column(nullable = false)
	private Integer courseFees;
	
	 @Column(nullable = false)
	private String batchName;
	
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
   // @JoinColumn(name = "student_id")  // Foreign key column for Student
	@JsonManagedReference
    private List<Student> student;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Integer courseId, String courseName, String courseDuration, Integer courseFees, String batchName,
			List<Student> student) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
		this.batchName = batchName;
		this.student = student;
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

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", courseFees=" + courseFees + ", batchName=" + batchName + ", student=" + student + "]";
	}

}
