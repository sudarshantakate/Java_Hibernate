package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aadhar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aadharId;
	
	private int aadharNumber;

	public int getAadharId() {
		return aadharId;
	}

	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}

	public int getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Override
	public String toString() {
		return "Aadhar [aadharId=" + aadharId + ", aadharNumber=" + aadharNumber + "]";
	}
	
	
	

}
