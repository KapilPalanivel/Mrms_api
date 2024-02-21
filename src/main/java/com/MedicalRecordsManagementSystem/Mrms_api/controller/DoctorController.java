package com.MedicalRecordsManagementSystem.Mrms_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Doctor;
import com.MedicalRecordsManagementSystem.Mrms_api.services.DoctorServices;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    @Autowired
    private DoctorServices doctorService;

    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<Doctor>> getDoctors() {
        try {
            List<Doctor> doctors = doctorService.getAllDoctors();
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getDoctor")
    public ResponseEntity<Doctor> getDoctor(@RequestParam long id) {
        try {
            Doctor doctor = doctorService.getDoctorById(id);
            if (doctor != null) {
                return ResponseEntity.ok(doctor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor pm) {
        try {
            doctorService.addDoctor(pm);
            return ResponseEntity.ok(pm);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
