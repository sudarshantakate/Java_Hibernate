package com.model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Address entity for Hibernate/JPA
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    private String aname;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private Student student;

    // ----- Constructors -----
    public Address() {
    }

    public Address(String aname, Student student) {
        this.aname = aname;
        this.setStudent(student); // keep both sides synced
    }

    // ----- Getters / Setters -----
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Student getStudent() {
        return student;
    }

    /**
     * Maintain bidirectional sync between Student <-> Address.
     */
    public void setStudent(Student student) {
        // unlink old relation
        if (this.student != null && this.student != student) {
            this.student.setAddress(null);
        }

        this.student = student;

        // Ensure other side is updated
        if (student != null && student.getAddress() != this) {
            student.setAddress(this);
        }
    }

    // ----- equals / hashCode -----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return aid == address.aid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid);
    }

    // ----- toString -----
    @Override
    public String toString() {
        String studentInfo = "null";
        if (student != null) {
            studentInfo = "Student[id=" + student.getSid() + ", name=" + student.getSname() + "]";
        }
        return "Address [aid=" + aid + ", aname=" + aname + ", student=" + studentInfo + "]";
    }
}
