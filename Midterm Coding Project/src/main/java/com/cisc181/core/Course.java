package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int CoursePoints;
	
	public Course(String courseName, int coursePoints) {
		super();
		this.CourseID = UUID.randomUUID();
		CourseName = courseName;
		CoursePoints = coursePoints;
	}
	public UUID getCourseID() {
		return CourseID;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getCoursePoints() {
		return CoursePoints;
	}
	public void setCoursePoints(int coursePoints) {
		CoursePoints = coursePoints;
	}
	
	
	
}
