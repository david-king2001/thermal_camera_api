package com.example.TAC_api.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.TAC_api.model.ThermalData;
import com.example.TAC_api.repo.ThermalDataRepo;

@Service
public class TACService {
    private final ThermalDataRepo thermalDataRepo;

    @Autowired
    public TACService(ThermalDataRepo thermalDataRepo) {
        this.thermalDataRepo = thermalDataRepo;
    }

    public List<ThermalData> getAllThermalData() {
        return thermalDataRepo.findAll();
    }

    public ThermalData getThermalDataById(long id)
    {
        return thermalDataRepo.findById(id);
    }

    public ThermalData getLatestThermalData()
    {
        return thermalDataRepo.findLatestThermalData();
    }
    @Transactional
    public void saveThermalData(ThermalData data) {
        System.out.print("saveThermalData ");
        System.out.println(data.getThermalData()[500]);
        thermalDataRepo.save(data);
    }

    public void deleteThermalData(Long id) {
        thermalDataRepo.deleteById(id);
    }

    // Other methods as needed
}
