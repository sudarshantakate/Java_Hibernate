package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	private String sName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Student_Id")
	private List<Subject> subjects = new ArrayList<Subject>();

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public List<Subject> getSubject() {
		return subjects;
	}

	public void setSubject(List<Subject> subject) {
		this.subjects = subject;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", subject=" + subjects + "]";
	}

}