package com.MedicalRecordsManagementSystem.Mrms_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Doctor { 
    @Id
    private long doctorId;
    private int age;
    private String name;
    @Column(unique = true)
    private String number;
    @Column(unique = true)
    private String email;
    private String password;
    private String dept;
    private String dob;



    //

    // @OneToOne(cascade = CascadeType.ALL)
    // public Doctor doctor;

    //

    public Doctor() {
    } 

    public Doctor(long doctorId, int age, String name, String number, String email, String password, String dept,
            String dob) {
        this.doctorId = doctorId;
        this.age = age;
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.dept = dept;
        this.dob = dob;
    }

    public long getId() {
        return doctorId;
    }

    public void setId(long doctorId) {
        this.doctorId = doctorId;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
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
    @JsonIgnore
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
