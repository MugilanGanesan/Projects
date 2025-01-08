package com.studentAndCourse.StudentAndCourse.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {
	
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
	
	 @ManyToOne
	 @JoinColumn(name = "course_id")
	@JsonBackReference // Manage the reference to prevent circular dependency
	private Course course;

	public Student(Integer studentId, String studentName, @Email(message = "Invalid email format") String studentEmail,
		  String studentMobile,
			Course course) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentMobile = studentMobile;
		this.course = course;
	}

	public Student() {
		 
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentMobile=" + studentMobile + "]";
	}	 

}
