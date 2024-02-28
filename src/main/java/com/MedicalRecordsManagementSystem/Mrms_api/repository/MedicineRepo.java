package com.MedicalRecordsManagementSystem.Mrms_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine,Integer>{
    
}
