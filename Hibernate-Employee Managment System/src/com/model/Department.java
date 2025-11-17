package com.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Did;
	
	private String dname;
	
	@OneToMany
	@JoinColumn(name= "empids" ,referencedColumnName = "Did")
	private List<Employee> emplist = new ArrayList<Employee>();

	public int getDid() {
		return Did;
	}

	public void setDid(int did) {
		Did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}

	@Override
	public String toString() {
		return "Department [Did=" + Did + ", dname=" + dname + ", emplist=" + emplist + "]";
	}
	
	
	
	
}
