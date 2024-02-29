package com.MedicalRecordsManagementSystem.Mrms_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor { 
    @Id
    private long doctorId;
    private int age;
    private String name;
    @Column(unique = true)
    private String number;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String dept;
    private String dob;
    //

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "doctor")
    @JsonManagedReference
    public Set<PatientModel> patientModel;

    //
}
