package com.StudentAndCourse.Consumer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
public class SalemStudents {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	private String studentName;
	
	@Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
	private String studentEmail;
	
	 @Column(name = "Student_Mobile", nullable = false)
	 @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
	private String studentMobile;
	
	 @Column(name = "course_id", nullable = false)
	 private Long courseId;
	 
	@Transient // Ensures this field is not persisted in the database
	 private Course course;

	public SalemStudents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalemStudents(Integer studentId, String studentName,
			@Email(message = "Invalid email format") String studentEmail,
			@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits") String studentMobile,
			Long courseId, Course course) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentMobile = studentMobile;
		this.courseId = courseId;
		this.course = course;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "SalemStudents [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail="
				+ studentEmail + ", studentMobile=" + studentMobile + ", courseId=" + courseId + ", course=" + course
				+ "]";
	}


	
}
