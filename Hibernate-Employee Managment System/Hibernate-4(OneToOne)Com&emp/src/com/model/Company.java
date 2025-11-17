package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmpId;
	
	private String cmpName;
	
	private String cmpAddress;
	
	private String cmpType;
	
	
	private int cmpPinCode;

	public int getCmpId() {
		return cmpId;
	}

	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getCmpAddress() {
		return cmpAddress;
	}

	public void setCmpAddress(String cmpAddress) {
		this.cmpAddress = cmpAddress;
	}

	public String getCmpType() {
		return cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	public int getCmpPinCode() {
		return cmpPinCode;
	}

	public void setCmpPinCode(int cmpPinCode) {
		this.cmpPinCode = cmpPinCode;
	}

	@Override
	public String toString() {
		return "Company [cmpId=" + cmpId + ", cmpName=" + cmpName + ", cmpAddress=" + cmpAddress + ", cmpType="
				+ cmpType + ", cmpPinCode=" + cmpPinCode + "]";
	}
	
	
}
