package com.MedicalRecordsManagementSystem.Mrms_api.repository;

import org.springframework.stereotype.Repository;

import com.MedicalRecordsManagementSystem.Mrms_api.model.PatientModel;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PatientRepository extends JpaRepository<PatientModel,Long> {
    
}
