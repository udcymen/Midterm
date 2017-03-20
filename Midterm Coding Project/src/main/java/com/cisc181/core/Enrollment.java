package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;


	private Enrollment(){
		super();
		EnrollmentID = UUID.randomUUID();
	}
	
	public Enrollment(UUID StudentID, UUID SectionID){
		this.SectionID = SectionID;
		this.StudentID = StudentID;
		EnrollmentID = UUID.randomUUID();
	}

	public double getGrade() {
		return Grade;
	}

	public void setGrade(double grade) {
		Grade = grade;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	
	
	
	
	
}
