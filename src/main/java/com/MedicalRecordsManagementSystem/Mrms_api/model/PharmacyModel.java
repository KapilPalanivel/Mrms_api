package com.MedicalRecordsManagementSystem.Mrms_api.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PharmacyModel {
    @Id
    private int medicineId;
    private String medicineName;
    private int stock;
    private String medicineBrand;
    private Date expiryDate;
    private String vendorName;
    public PharmacyModel(int medicineId, String medicineName, int stock, String medicineBrand, Date expiryDate,
            String vendorName) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.stock = stock;
        this.medicineBrand = medicineBrand;
        this.expiryDate = expiryDate;
        this.vendorName = vendorName;
    }
    public PharmacyModel() {
    }
    public int getMedicineId() {
        return medicineId;
    }
    public String getMedicineName() {
        return medicineName;
    }
    public int getStock() {
        return stock;
    }
    public String getMedicineBrand() {
        return medicineBrand;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public String getVendorName() {
        return vendorName;
    }
    
}
