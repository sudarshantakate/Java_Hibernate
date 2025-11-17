package com.model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Student entity for Hibernate/JPA
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    private String sname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", unique = true)
    private Address address;

    // ----- Constructors -----
    public Student() {
    }

    /**
     * Convenience constructor (ID left to JPA)
     */
    public Student(String sname, Address address) {
        this.sname = sname;
        this.setAddress(address); // use setter to keep both sides in sync
    }

    // ----- Getters / Setters -----
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address and keeps the bidirectional link consistent.
     * If you pass null, it will unlink the previous address from this student.
     */
    public void setAddress(Address address) {
        // unlink old address if present
        if (this.address != null && this.address != address) {
            this.address.setStudent(null);
        }

        this.address = address;

        if (address != null && address.getStudent() != this) {
            address.setStudent(this);
        }
    }

    // ----- equals / hashCode -----
    // Use only the identifier (sid). If entities are compared before persist,
    // you may want a different strategy. This is a simple, common approach.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return sid == student.sid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid);
    }

    // ----- toString -----
    // Avoid printing full Address.toString() (would cause recursion). Print address id & name only.
    @Override
    public String toString() {
        String addrInfo = "null";
        if (address != null) {
            addrInfo = "Address[id=" + address.getAid() + ", name=" + address.getAname() + "]";
        }
        return "Student [sid=" + sid + ", sname=" + sname + ", address=" + addrInfo + "]";
    }
}
