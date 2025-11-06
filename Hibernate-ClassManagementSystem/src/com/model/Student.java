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
@Table(name = "Student Details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student ID")
	private int studentId;

	@Column(name = "Student Name")
	private String studentName;

	@Column(name = "Student Address")
	private String studentAddress;

	@Column(name = "Student Mobile No.")
	private double studentMobileNo;

	@Column(name = "Student Email ID")
	private String studentEmailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Batch batch;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public double getStudentMobileNo() {
		return studentMobileNo;
	}

	public void setStudentMobileNo(double studentMobileNo) {
		this.studentMobileNo = studentMobileNo;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentMobileNo=" + studentMobileNo + ", studentEmailId=" + studentEmailId + ", batch=" + batch
				+ "]";
	}
	
	
}
