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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
    private PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }
    @PostMapping("/api/post")
    public ResponseEntity<PharmacyModel> saveMedicine(@RequestBody PharmacyModel pharmacyModel)
    {
        PharmacyModel p= pharmacyService.saveMedicine(pharmacyModel);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }
    @GetMapping("/api/getMedicines")
    public ResponseEntity<List<PharmacyModel>> getMedicines() {
        List<PharmacyModel> list=pharmacyService.getAllMedicines();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/getMedicine{id}")
    public  ResponseEntity<PharmacyModel> getById(@PathVariable int id) {
        PharmacyModel p=pharmacyService.getById(id);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<PharmacyModel> putMedicine(@PathVariable int id, @RequestBody PharmacyModel pharmacyModel) {
        if(pharmacyService.updateMedicine(id, pharmacyModel))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PharmacyModel> deleteMedicine(@PathVariable int id)
    {
        if(pharmacyService.deleteMedicineById(id))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
