
package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AdharBidirection")
public class Adhar{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	private long adharNo;
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "Adhar [aId=" + aId + ", adharNo=" + adharNo + "]";
	}

}
