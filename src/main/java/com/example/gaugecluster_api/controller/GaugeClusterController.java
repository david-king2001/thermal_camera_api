package com.example.gaugecluster_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.gaugecluster_api.service.GaugeClusterService;
import com.example.gaugecluster_api.model.GaugeClusterData;
import com.example.gaugecluster_api.dto.GaugeClusterDataDTO;

import java.util.List;

@RestController
@RequestMapping("/api/gauge-cluster-data")
public class GaugeClusterController {
    private final GaugeClusterService gaugeClusterService;

    @Autowired
    public GaugeClusterController(GaugeClusterService gaugeClusterService) {
        this.gaugeClusterService = gaugeClusterService;
    }


    @GetMapping()
    public List<GaugeClusterData> getGaugeClusterDataById(@RequestParam("gaugeClusterId") String id) {
        return gaugeClusterService.getGaugeClusterDataById(id);
    }

    @PostMapping
    public ResponseEntity<Void> addGaugeData(@RequestBody GaugeClusterDataDTO gaugeDataDTO) {
        GaugeClusterData gaugeClusterData = new GaugeClusterData();
        // Map the properties from the DTO to the entity
        gaugeClusterData.setGaugeClusterId(gaugeDataDTO.getGaugeClusterId());
        gaugeClusterData.setSpeed(gaugeDataDTO.getSpeed());
        gaugeClusterData.setRpm(gaugeDataDTO.getRpm());
        gaugeClusterData.setFuelLevel(gaugeDataDTO.getFuelLevel());
        gaugeClusterData.setEngineTemperature(gaugeDataDTO.getEngineTemperature());

        // Call the service method to save the gauge cluster data
        gaugeClusterService.saveGaugeClusterData(gaugeClusterData);
        System.out.println("Received");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public void deleteGaugeClusterData(@PathVariable Long id) {
        gaugeClusterService.deleteGaugeClusterData(id);
    }

    // Other endpoints as needed
}