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
@Table(name = "Batch_Details")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Batch_ID")
	private int batchId;
	
	@Column(name = "Batch_Name")
	private String batchName;
	
	@Column(name = "Batch_Time")
	private String batchTime;
	
	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Faculty Faculty;
	
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Faculty getFaculty() {
		return Faculty;
	}

	public void setFaculty(Faculty faculty) {
		Faculty = faculty;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", batchTime=" + batchTime + ", Faculty="
				+ Faculty + "]";
	}

	
	
	
}
