package com.MedicalRecordsManagementSystem.Mrms_api.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel {
    @Id
    private long id;
    private int age;
    private String name;
    private String phone_number;
    private String email;
    @JsonIgnore
    private String password;
    private String department_consulting;
    @Column(updatable = false, name = "dob")
    private Date date_of_birth;
    @Column(updatable = false, insertable = true)
    private String gender;
    /*
     * relation with Doctor
     */
    
    @ManyToOne
    @JoinColumn(name = "Doctor_id")
    @JsonBackReference
    public Doctor doctor;
}
