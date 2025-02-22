package com.studentAndCourse.StudentAndCourse.dto;

import java.util.List;

public class StudentDTO {
	
	 private Integer studentId;
	    
	    private String studentName;
	    private String studentEmail;
	    private String studentMobile;
	    private List<CourseDTO> courses;
	    
		public StudentDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public StudentDTO(Integer studentId, String studentName, String studentEmail, String studentMobile,
				List<CourseDTO> courses) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentEmail = studentEmail;
			this.studentMobile = studentMobile;
			this.courses = courses;
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
		public List<CourseDTO> getCourses() {
			return courses;
		}
		public void setCourses(List<CourseDTO> courses) {
			this.courses = courses;
		}
		@Override
		public String toString() {
			return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail="
					+ studentEmail + ", studentMobile=" + studentMobile + ", courses=" + courses + "]";
		}
		
	
}
