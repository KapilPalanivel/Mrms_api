package com.MedicalRecordsManagementSystem.Mrms_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Doctorid;
    private int age;
    private String name;
    @Column(unique = true)
    private String number;
    @Column(unique = true)
    private String email;
    private String password;
    private String dept;
    private String dob;

    public Doctor() {
    }

    public Doctor(long doctorid, int age, String name, String number, String email, String password, String dept,
            String dob) {
        Doctorid = doctorid;
        this.age = age;
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.dept = dept;
        this.dob = dob;
    }

    public long getId() {
        return Doctorid;
    }

    public void setId(long Doctorid) {
        this.Doctorid = Doctorid;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDoctorid() {
        return Doctorid;
    }

    public void setDoctorid(long doctorid) {
        Doctorid = doctorid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
