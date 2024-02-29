package com.MedicalRecordsManagementSystem.Mrms_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medicine {

    @Id
    private int medicineId;
    private String medicineString;
    private String manufacturedName;
    private String medicineBrand;
    private String dosage;

    @JsonBackReference
    @JoinColumn(name = "pharmacy_id")
    @ManyToOne
    private PharmacyModel pharmacyModel;
}
