package com.entity;

public class Employee {

	private int empId;

	private String empName;

	private double salarry;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalarry() {
		return salarry;
	}

	public void setSalarry(double salarry) {
		this.salarry = salarry;
		
		
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salarry=" + salarry + "]";
	}
}
