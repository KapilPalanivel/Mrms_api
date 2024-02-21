package com.MedicalRecordsManagementSystem.Mrms_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalRecordsManagementSystem.Mrms_api.model.PharmacyModel;

@Repository
public interface PharmacyRepo extends JpaRepository<PharmacyModel,Integer> {
     
}
