package com.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String pname;
    private String paddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhar_id") // foreign key column in Person table
    private Aadhar aadhar;

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    @Override
    public String toString() {
        return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", aadhar=" + aadhar + "]";
    }
}
