package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name = "User_ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto increment ID
	private int uid;

	@Column(name = "User_Name")
	private String uname;

	@Column(name = "User_address")
	private String uaddress;

	@Column(name = "EmailId")
	private String email;

	@Column(name = "Password")
	private String password;

	@Column(name = "User_age")
	private int age;
	
	@Column(name = "User_Salary")
	private double salary;

	public double getSalarry() {
		return salary;
	}

	public void setSalarry(double salarry) {
		this.salary = salarry;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + ", email=" + email + ", password="
				+ password + ", age=" + age + ", salarry=" + salary + "]";
	}

}
