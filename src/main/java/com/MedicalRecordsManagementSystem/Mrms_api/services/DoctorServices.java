package com.MedicalRecordsManagementSystem.Mrms_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Doctor;
import com.MedicalRecordsManagementSystem.Mrms_api.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServices {
    @Autowired
    private DoctorRepository doctorRepo;

    public Doctor addDoctor(Doctor doctor) {
       return doctorRepo.save(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }
  
    public Doctor getDoctorById(long id) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        return optionalDoctor.orElse(null);
    }
    public boolean updateDoctor(Long id , Doctor doctor)
    {
        if(this.getDoctorById(id) ==  null)
        return false;
        try {
            doctorRepo.save(doctor);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean deleteDoctor(Long id)
    {
        if(this.getDoctorById(id) ==  null)
        return false;
        try {
            doctorRepo.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /*
     * pagination and sorting
     */
    public List<Doctor> getPage(int offset , int size)
    {
        return doctorRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<Doctor> getSortedPage(int offset , int size , String field)
    {
        return doctorRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }

    /*
     * Queries
     */

     //
     public List<Doctor> nameStartsWith(String name)
     {
        return doctorRepo.findByNameStartingWith(name);
     }
}
