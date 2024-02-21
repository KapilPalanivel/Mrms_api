package com.MedicalRecordsManagementSystem.Mrms_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MedicalRecordsManagementSystem.Mrms_api.model.PharmacyModel;
import com.MedicalRecordsManagementSystem.Mrms_api.repository.PharmacyRepo;

@Service
public class PharmacyService {
    private PharmacyRepo pharmacyRepo;

    public PharmacyService(PharmacyRepo pharmacyRepo) {
        this.pharmacyRepo = pharmacyRepo;
    }
    public PharmacyModel saveMedicine(PharmacyModel pharmacyModel)
    {
        return pharmacyRepo.save(pharmacyModel);
    }
    public List<PharmacyModel> getAllMedicines()
    {
        return pharmacyRepo.findAll();
    }
    public PharmacyModel getById(int id)
    {
        return pharmacyRepo.findById(id).orElse(null);
    }
    public boolean updateMedicine(int id,PharmacyModel pharmacyModel)
    {
        if(getById(id)==null)
        {
            return false;
        }
        pharmacyRepo.save(pharmacyModel);
        return true;
    }
    public boolean deleteMedicineById(int id)
    {
        if(getById(id)==null)
        return false;
        pharmacyRepo.deleteById(id);
        return true;
    }
}
