package com.MedicalRecordsManagementSystem.Mrms_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    
}
