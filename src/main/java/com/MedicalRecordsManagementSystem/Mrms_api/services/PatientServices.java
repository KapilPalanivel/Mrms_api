package com.MedicalRecordsManagementSystem.Mrms_api.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalRecordsManagementSystem.Mrms_api.model.PatientModel;
import com.MedicalRecordsManagementSystem.Mrms_api.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientServices {
    @Autowired
    private PatientRepository patRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings({ "null", "deprecation" })
    public String savePatient(PatientModel pmodel) {

        System.out.println("Current :" + getCurrentDate().getYear() + " " + pmodel.getDate_of_birth().getYear());
        if (getCurrentDate().getYear() > pmodel.getDate_of_birth().getYear()) {
            int age = getCurrentDate().getYear() - pmodel.getDate_of_birth().getYear();
            pmodel.setAge(age);
            patRepo.save(pmodel);
            return "Success";
        } else {
            return "Enter a valid age";
        }
    }

    @SuppressWarnings("null")
    public LocalDate getCurrentDate() {
        String sql = "SELECT CURRENT_DATE()";
        Date currentDate = jdbcTemplate.queryForObject(sql, Date.class);
        return currentDate.toLocalDate();
    }

    public List<PatientModel> getPatient() {
        return patRepo.findAll();
    }

    public PatientModel getPatientById(long id) {
        Optional<PatientModel> po = patRepo.findById(id);
        return po.orElseThrow(() -> new EntityNotFoundException("Searched Content Not Present"));
    }

    public boolean updatePatient()
    {
        return true;
    }
}
