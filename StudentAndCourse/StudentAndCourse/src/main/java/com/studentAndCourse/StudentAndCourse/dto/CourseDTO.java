package com.studentAndCourse.StudentAndCourse.dto;

import java.util.List;

public class CourseDTO {
	
	private Integer courseId;
    private String courseName;
    private String courseDuration;
    private Integer courseFees;
    
     private List<StudentDTO> students;
	    
		public CourseDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CourseDTO(Integer courseId, String courseName, String courseDuration, Integer courseFees,
				List<StudentDTO> students) {
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

		public List<StudentDTO> getStudents() {
			return students;
		}

		public void setStudents(List<StudentDTO> students) {
			this.students = students;
		}

		@Override
		public String toString() {
			return "CourseDTO [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
					+ courseDuration + ", courseFees=" + courseFees + ", students=" + students + "]";
		}

		
}
