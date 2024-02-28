package com.MedicalRecordsManagementSystem.Mrms_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MedicalRecordsManagementSystem.Mrms_api.model.Medicine;
import com.MedicalRecordsManagementSystem.Mrms_api.repository.MedicineRepo;

@Service
public class MedicineServices {
    private MedicineRepo medicineRepo;

    public MedicineServices(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }
    public Medicine postMedicine(Medicine medicine)
    {
        return medicineRepo.save(medicine);
    }
    public List<Medicine> getAll()
    {
        return medicineRepo.findAll();
    }
    public Medicine getById(int id)
    {
        return medicineRepo.findById(id).orElse(null);
    }
    public boolean putDetail(int id,Medicine medicine)
    {
        if(getById(id)==null)
        {
            return false;
        }
        medicineRepo.save(medicine);
        return true;
    }
    public boolean deleteById(int id)
    {
        if(getById(id)==null)
        {
            return false;
        }
        medicineRepo.deleteById(id);
        return true;
    }
}
