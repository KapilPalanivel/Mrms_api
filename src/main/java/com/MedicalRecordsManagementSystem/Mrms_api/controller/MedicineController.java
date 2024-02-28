package com.MedicalRecordsManagementSystem.Mrms_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Medicine;
import com.MedicalRecordsManagementSystem.Mrms_api.services.MedicineServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/medicine")
public class MedicineController {
    private MedicineServices medicineServices;

    public MedicineController(MedicineServices medicineServices) {
        this.medicineServices = medicineServices;
    }
    @PostMapping("/post")
    public ResponseEntity<Medicine> postmMedicine(@RequestBody Medicine medicine) {
        Medicine m=medicineServices.postMedicine(medicine);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Medicine>> getAll() {
        List<Medicine> list=medicineServices.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PutMapping("put/{id}")
    public ResponseEntity<Medicine> putMedicine(@PathVariable int id, @RequestBody Medicine medicine ) {
       if(medicineServices.putDetail(id, medicine))
       {
        return new ResponseEntity<>(medicine,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteMedicine(@PathVariable int id)
    {
        if(medicineServices.deleteById(id))
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
