package com.MedicalRecordsManagementSystem.Mrms_api.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PharmacyModel {
    @Id
    private int pharmacyId;
    private int vendorId;
    private String vendorName;
    private String contractSigned;
    public PharmacyModel(int pharmacyId, int vendorId, String vendorName, String contractSigned) {
        this.pharmacyId = pharmacyId;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.contractSigned = contractSigned;
    }
    public int getPharmacyId() {
        return pharmacyId;
    }
    public int getVendorId() {
        return vendorId;
    }
    public String getVendorName() {
        return vendorName;
    }
    public String getContractSigned() {
        return contractSigned;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "pharmacyModel",cascade =CascadeType.ALL)
    private List<Medicine> medicine;
}
