package com.MedicalRecordsManagementSystem.Mrms_api.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientModel {
    @Id
    private long id;
    private String DoctorName;
    private int age;
    private String name;
    private String phone_number;
    private String email;
    private String password;
    private String department_consulting;
    @Column(updatable = false,name = "dob")
    private Date date_of_birth;
    @Column(updatable = false,insertable=true)
    private String gender;
    
    public PatientModel() {
    }

    

    public PatientModel(long id, String doctorid, int age, String name, String phone_number, String email,
            String password, String department_consulting, Date date_of_birth, String gender) {
        this.id = id;
        DoctorName = doctorid;
        this.age = age;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.department_consulting = department_consulting;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
    }



    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }



    public String getDoctorName() {
        return DoctorName;
    }



    public void setDoctorid(String doctorid) {
        DoctorName = doctorid;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getPhone_number() {
        return phone_number;
    }



    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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



    public String getDepartment_consulting() {
        return department_consulting;
    }



    public void setDepartment_consulting(String department_consulting) {
        this.department_consulting = department_consulting;
    }



    public Date getDate_of_birth() {
        return date_of_birth;
    }



    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }



    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }


}
