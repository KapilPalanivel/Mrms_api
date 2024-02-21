package com.MedicalRecordsManagementSystem.Mrms_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.MedicalRecordsManagementSystem.Mrms_api.model.PharmacyModel;
import com.MedicalRecordsManagementSystem.Mrms_api.services.PharmacyService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
    private PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }
    @PostMapping("/api/post")
    public ResponseEntity<PharmacyModel> saveDetails(@RequestBody PharmacyModel pharmacyModel)
    {
        PharmacyModel p= pharmacyService.saveMedicine(pharmacyModel);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }
    @GetMapping("/api/getMedicines")
    public ResponseEntity<List<PharmacyModel>> getMethodName(@RequestParam String param) {
        return new SomeData();
    }
    
}
