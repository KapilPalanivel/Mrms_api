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
    private PatientRepository patientRepos;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings({ "null" })
    public String savePatient(PatientModel pmodel) {
        return (patientRepos.save(pmodel).toString());
    }

    @SuppressWarnings("null")
    public LocalDate getCurrentDate() {
        String sql = "SELECT CURRENT_DATE()";
        Date currentDate = jdbcTemplate.queryForObject(sql, Date.class);
        return currentDate.toLocalDate();
    }

    public List<PatientModel> getPatient() {
        return patientRepos.findAll();
    }

    public PatientModel getPatientById(long id) {
        Optional<PatientModel> po = patientRepos.findById(id);
        return po.orElseThrow(() -> new EntityNotFoundException("Searched Content Not Present"));
    }

    @SuppressWarnings({ "null", "unused" })
    public boolean updatePatient(long id,PatientModel patientModel)
    {
        if(patientRepos.findById(id)!=null)
        {
            patientRepos.save(patientModel);
            return true;
        }
        else
            return false;
    }

    public void deletePatientById(long id) {
        patientRepos.deleteById(id);
    }
}
    
