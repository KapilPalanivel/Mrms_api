package com.MedicalRecordsManagementSystem.Mrms_api.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Doctor;
import com.MedicalRecordsManagementSystem.Mrms_api.services.DoctorServices;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    @Autowired
    private DoctorServices doctorService;

    @GetMapping("/getAllDoctors")   
    public ResponseEntity<List<Doctor>> getDoctors() {
        try {
            List<Doctor> doctors = doctorService.getDoctors();
            return new ResponseEntity<>(doctors,HttpStatus.OK);
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
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor d = doctorService.addDoctor(doctor);
            if(d != null)
            return new ResponseEntity<>(doctor,HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @SuppressWarnings("null")
    @PutMapping("putDoctor/{id}")
    public ResponseEntity<Doctor> putMethodName(@PathVariable ("id") Long id, @RequestBody Doctor doctor) {
        if(doctorService.updateDoctor(id , doctor) == true)
        return new ResponseEntity<>(doctor , HttpStatus.OK);
        return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("deleteDoctor/{id}")
    public ResponseEntity<Doctor> deleteMethodName(@PathVariable ("id") Long id) {
        if(doctorService.deleteDoctor(id) == true)
        return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
    /*
     * pagination and sorting
     */
    @GetMapping("/getPage/{offset}/{size}")
    public ResponseEntity<List<Doctor>> getPage(@PathVariable int offset , @PathVariable int size) {
        List<Doctor> list = doctorService.getPage(offset, size);
        if(list.size() > 0)
        return new ResponseEntity<>(list , HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @SuppressWarnings("unchecked")
    @GetMapping("/getSortedPage/{offset}/{size}/{field}")
    public ResponseEntity<List <Doctor>> getPage(@PathVariable int offset , @PathVariable int size ,@PathVariable String field) {
        @SuppressWarnings("rawtypes")
        List p = doctorService.getSortedPage(offset, size, field);
        return new ResponseEntity<>(p , HttpStatus.OK);
    }
    
    @GetMapping("/getByNameSatrtsWith/{name}")
     public List<Doctor> nameStartsWith(@PathVariable String name)
     {
        return doctorService.nameStartsWith(name);
     }

}
