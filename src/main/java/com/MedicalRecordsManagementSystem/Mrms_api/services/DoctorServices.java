package com.MedicalRecordsManagementSystem.Mrms_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Doctor;
import com.MedicalRecordsManagementSystem.Mrms_api.repository.DoctorRepository;

@Service
public class DoctorServices {
    @Autowired
    private DoctorRepository doctorRepo;

    @SuppressWarnings("null")
    public void addDoctor(Doctor doctor) {
       try{
        doctorRepo.save(doctor);
       }
       catch(Exception e)
       {
           System.out.println("Error");
           System.out.println(e.toString());
           System.out.println("Error");
       }
    }

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }
  
    public Doctor getDoctorById(long id) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        return optionalDoctor.orElse(null);
    }
}
