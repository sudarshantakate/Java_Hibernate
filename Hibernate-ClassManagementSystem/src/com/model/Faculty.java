package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty Deatils")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Faculty ID")
	private int facultyId;
	
	@Column(name = "Faculty Name")
	private String facultyName;
	
	@Column(name = "Faculty Address")
	private String facultyAddress;
	
	@Column(name = "Faculty Mobile NUmber")
	private double facultyMobileNo;
	
	@Column(name = "Faculty Email ID")
	private String facultyEmailID;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyAddress() {
		return facultyAddress;
	}

	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}

	public double getFacultyMobileNo() {
		return facultyMobileNo;
	}

	public void setFacultyMobileNo(double facultyMobileNo) {
		this.facultyMobileNo = facultyMobileNo;
	}

	public String getFacultyEmailID() {
		return facultyEmailID;
	}

	public void setFacultyEmailID(String facultyEmailID) {
		this.facultyEmailID = facultyEmailID;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyAddress=" + facultyAddress
				+ ", facultyMobileNo=" + facultyMobileNo + ", facultyEmailID=" + facultyEmailID + ", course=" + course
				+ "]";
	}
	
	
}
