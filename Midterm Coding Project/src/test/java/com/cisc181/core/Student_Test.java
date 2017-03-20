package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

import pkgException.PersonException;

public class Student_Test {

	private static ArrayList<Course> course = new ArrayList<Course>();
	private static ArrayList<Semester> semester = new ArrayList<Semester>();
	private static ArrayList<Section> section = new ArrayList<Section>();
	private static ArrayList<Student> student = new ArrayList<Student>();
	private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	@BeforeClass
	public static void setup() throws PersonException {
		
		Course course1 = new Course("CourseA", 3);
		Course course2 = new Course("CourseB", 4);		
		Course course3 = new Course("CourseC", 3);
		
		course.add(course1);
		course.add(course2);
		course.add(course3);
		
		Calendar start = Calendar.getInstance();
		start.set(2016, 9, 1);
		Calendar end = Calendar.getInstance();
		end.set(2017, 1, 30);
		Semester sm1 = new Semester(start.getTime(), end.getTime());
		Calendar start1 = Calendar.getInstance();
		start.set(2017, 2, 1);
		Calendar end1 = Calendar.getInstance();
		end.set(2017, 5, 30);
		Semester sm2 = new Semester(start1.getTime(), end1.getTime());
		
		semester.add(sm1);
		semester.add(sm2);
		
		Section section1 = new Section(course1.getCourseID(), sm1.getSemesterID(), 100);
		Section section2 = new Section(course1.getCourseID(), sm2.getSemesterID(), 101);
		Section section3 = new Section(course2.getCourseID(), sm1.getSemesterID(), 102);
		Section section4 = new Section(course2.getCourseID(), sm2.getSemesterID(), 103);
		Section section5 = new Section(course3.getCourseID(), sm1.getSemesterID(), 104);
		Section section6 = new Section(course3.getCourseID(), sm2.getSemesterID(), 105);
		
		section.add(section1);
		section.add(section2);
		section.add(section3);
		section.add(section4);
		section.add(section5);
		section.add(section6);
		
		
		Calendar birth = Calendar.getInstance();
		birth.set(1997, 9, 1);
		Student student1 = new Student("Cong", "", "Meng", birth.getTime(), 
				eMajor.BUSINESS, "", "(215)-820-8056", "");
		Student student2 = new Student("Cong1", "", "Meng", birth.getTime(), 
				eMajor.CHEM, "", "(215)-820-8056", "");
		Student student3 = new Student("Cong2", "", "Meng", birth.getTime(), 
				eMajor.COMPSI, "", "(215)-820-8056", "");
		Student student4 = new Student("Cong3", "", "Meng", birth.getTime(), 
				eMajor.NURSING, "", "(215)-820-8056", "");
		Student student5 = new Student("Cong4", "", "Meng", birth.getTime(), 
				eMajor.PHYSICS, "", "(215)-820-8056", "");
		Student student6 = new Student("Cong5", "", "Meng", birth.getTime(), 
				eMajor.BUSINESS, "", "(215)-820-8056", "");
		Student student7 = new Student("Cong6", "", "Meng", birth.getTime(), 
				eMajor.CHEM, "", "(215)-820-8056", "");
		Student student8 = new Student("Cong7", "", "Meng", birth.getTime(), 
				eMajor.NURSING, "", "(215)-820-8056", "");
		Student student9 = new Student("Cong8", "", "Meng", birth.getTime(), 
				eMajor.PHYSICS, "", "(215)-820-8056", "");
		Student student10 = new Student("Cong9", "", "Meng", birth.getTime(), 
				eMajor.BUSINESS, "", "(215)-820-8056", "");
		
		student.add(student1);
		student.add(student2);
		student.add(student3);
		student.add(student4);
		student.add(student5);
		student.add(student6);
		student.add(student7);
		student.add(student8);
		student.add(student9);
		student.add(student10);
		
		for (Student s : student){
			for (Section sec : section){
				Enrollment e = new Enrollment(s.getStudentID(), sec.getScetionID());
				e.setGrade(100);
				enrollments.add(e);
			}
		}
		
		
	}

	@Test
	public void testGPA() {
		int GPA = 0;
		for (Student s : student){
			for (Enrollment enrol : enrollments){
				for (Section sec : section){
					for (Course c : course){
						if(enrol.getSectionID().toString()
								.equals(sec.getScetionID().toString())){
							if(enrol.getStudentID().toString()
									.equals(s.getStudentID().toString())){
								if(c.getCourseID().toString()
										.equals(sec.getCourseID().toString())){
									GPA += c.getCoursePoints();
								}
							}
						}
					}
				}
			}
		}
		GPA = GPA / student.size();
		assertEquals(GPA, 20);
	}
	
	
	@Test
	public void testAverageGrade() {
		int Grade = 0;
		for (Course course : course) {
			for (Section section : section) {
				if (section.getCourseID().toString()
						.equals(course.getCourseID().toString())) {
					for (Enrollment enrollment : enrollments) {
						if (section.getScetionID().toString()
								.equals(enrollment.getSectionID().toString())) {
							for (Student student : student) {
								if (student
										.getStudentID()
										.toString()
										.equals(enrollment.getStudentID()
												.toString())) {
									Grade += enrollment.getGrade();
								}
							}
						}
					}
				}
			}
		}
		int AverageGrade = Grade / (student.size() * section.size());
		assertEquals(100, AverageGrade);
	}
	
	
	@Test
	public void testChangeMajor() {
		UUID ID = student.get(0).getStudentID();
		for (Enrollment enrollment : enrollments) {
			if (ID.toString().equals((enrollment.getStudentID().toString()))) {
				for (Section section : section) {
					if (section.getScetionID().toString()
							.equals((enrollment.getSectionID().toString()))) {
						for (Course course : course) {
							if (course.getCourseID().toString()
									.equals((section.getCourseID().toString()))) {
								student.get(0).setMajor(eMajor.PHYSICS);
							}
						}
					}
				}
			}
		}
		assertEquals(student.get(0).getMajor(),
				eMajor.PHYSICS);
	}
	

}