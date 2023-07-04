package com.example.gaugecluster_api.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.gaugecluster_api.model.GaugeClusterData;
import com.example.gaugecluster_api.dto.GaugeClusterDataDTO;
import com.example.gaugecluster_api.repo.GaugeDataRepo;
import com.example.gaugecluster_api.exception.NotFoundException;
@Service
public class GaugeClusterService {
    private final GaugeDataRepo gaugeClusterRepo;

    @Autowired
    public GaugeClusterService(GaugeDataRepo gaugeClusterRepo) {
        this.gaugeClusterRepo = gaugeClusterRepo;
    }

    public List<GaugeClusterData> getAllGaugeClusterData() {
        return gaugeClusterRepo.findAll();
    }

    public List<GaugeClusterData> getGaugeClusterDataById(String id) {
        List<GaugeClusterData> gaugeClusterData;
        gaugeClusterData = gaugeClusterRepo.findAllByGaugeClusterId(id);
        return gaugeClusterData;
    }

    @Transactional
    public void saveGaugeClusterData(GaugeClusterData data) {
        gaugeClusterRepo.save(data);
    }

    public void deleteGaugeClusterData(Long id) {
        gaugeClusterRepo.deleteById(id);
    }

    // Other methods as needed
}
