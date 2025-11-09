package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="getAllEmployee",query ="from Employee")
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String eNnme;
	private double eSalary;
	private String eaddress;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteNnme() {
		return eNnme;
	}

	public void seteNnme(String eNnme) {
		this.eNnme = eNnme;
	}

	public double geteSalary() {
		return eSalary;
	}

	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eNnme=" + eNnme + ", eSalary=" + eSalary + ", eaddress=" + eaddress + "]";
	}

}
