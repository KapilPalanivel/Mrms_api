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

import com.MedicalRecordsManagementSystem.Mrms_api.model.PatientModel;
import com.MedicalRecordsManagementSystem.Mrms_api.services.PatientServices;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Patient")
public class PatientController {
    @Autowired
    private PatientServices patientService;

    @GetMapping("/getAllPatients")
    public ResponseEntity<?> getPatient() {
        try {
            List<PatientModel> patients = patientService.getPatient();
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/getPatient")
    public ResponseEntity<?> getPatient(@RequestParam long id) {
        try {
            PatientModel patient = patientService.getPatientById(id);
            if (patient != null) {
                return ResponseEntity.ok(patient);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PostMapping("/addPatient")
    public ResponseEntity<?> addPatient(@RequestBody PatientModel pm) {
        try {
            String kl = patientService.savePatient(pm);
            System.out.println(kl);
            return ResponseEntity.ok(pm);
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/updatePatients")
    public String putMethodName(@RequestParam long id, @RequestBody PatientModel patientModel) {
        if (patientService.updatePatient(id, patientModel)) {
            return "Success!";
        }
        return "Failed!";
    }
}
