package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//entity is an anotation for to create a table
@Table(name = "User_Details")//table is also an anotation to chnage name of table
public class User {

	@Id//Is user to anotate a column as a primary key
	@Column(name = "User_ID")
	private int uid;

	@Column(name = "Username")
	private String uname;

	@Column(name = "Mobile_Number")
	private long mobilenumber;

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

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", mobilenumber=" + mobilenumber + "]";
	}

}
