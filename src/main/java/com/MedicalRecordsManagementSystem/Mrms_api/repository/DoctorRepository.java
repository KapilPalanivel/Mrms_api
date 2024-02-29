package com.MedicalRecordsManagementSystem.Mrms_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{
    List<Doctor> findByNameStartingWith(String name);
}
