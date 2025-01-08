package com.StudentAndCourse.Consumer.Entity;

public class Course {
	
	private Integer courseId;

	private String courseName;
	
	private String courseDuration;
	
	private Integer courseFees;
	
	private String batchName;
	
	public Course() {
	
	}
	
	public Course(Integer courseId, String courseName, String courseDuration, Integer courseFees, String batchName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
		this.batchName = batchName;
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

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", courseFees=" + courseFees + ", batchName=" + batchName + "]";
	}
	
	
	
}
