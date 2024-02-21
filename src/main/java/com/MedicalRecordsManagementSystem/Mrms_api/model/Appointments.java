package com.MedicalRecordsManagementSystem.Mrms_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;

@Entity
public class Appointments {
    @Id
    @JoinTable
    private int Patientid;
    private int doctor_Consulting;
    private String name;
    private String phone_number;
    private String department;
    private String  gender;
    private String age;
    
    
    public Appointments() {
    }


    public Appointments(int patientid, int doctor_Consulting, String name, String phone_number, String department,
            String gender, String age) {
        Patientid = patientid;
        this.doctor_Consulting = doctor_Consulting;
        this.name = name;
        this.phone_number = phone_number;
        this.department = department;
        this.gender = gender;
        this.age = age;
    }


    public int getPatientid() {
        return Patientid;
    }


    public void setPatientid(int patientid) {
        Patientid = patientid;
    }


    public int getDoctor_Consulting() {
        return doctor_Consulting;
    }


    public void setDoctor_Consulting(int doctor_Consulting) {
        this.doctor_Consulting = doctor_Consulting;
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


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = age;
    }

     


}
