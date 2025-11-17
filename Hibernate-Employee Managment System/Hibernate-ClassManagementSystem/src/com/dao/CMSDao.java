package com.dao;

import java.util.List;

import com.model.*;

public interface CMSDao {

	public void addCourseInDao(Course course);

	public List<Course> displayCourseDetailsInDao();

	public void addFacultyInDao(Faculty faculty);

	public List<Faculty> displayFacultyDetailsInDao();

	public void addBatchInDao(String batchName, int facultyId);

	public void displayBatchDetailsInDao();

	public void addStudentInDao();

	public void displayStudentDetailsInDao();

}
