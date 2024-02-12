package com.example.TAC_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.TAC_api.service.TACService;
import com.example.TAC_api.model.ThermalData;
import com.example.TAC_api.dto.TACDTO;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/thermalData")
public class TACController {
    private final TACService tacService;

    @Autowired
    public TACController(TACService tacService) {
        this.tacService = tacService;
    }

    @PostMapping
    public ResponseEntity<Void> addThermalData(@RequestBody TACDTO tacDTO) {
        System.out.println(tacDTO.getThermalData()[500]);
        ThermalData tacData = new ThermalData();
        tacData.setThermalData(tacDTO.getThermalData());
        // Call the service method to save the gauge cluster data
        tacService.saveThermalData(tacData);
        System.out.println("Received");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ThermalData>> getAllThermalData(){
        List<ThermalData> thermalDataList = tacService.getAllThermalData();
        return ResponseEntity.ok().body(thermalDataList);
    }

    @GetMapping
    public ResponseEntity<ThermalData> getThermalData(@RequestParam("id") Long id){
        ThermalData thermalData = tacService.getThermalDataById(id);
        if (thermalData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(thermalData);
    }

    @GetMapping("/latest")
    public ResponseEntity<ThermalData> getLatestThermalData(){
        ThermalData thermalData = tacService.getLatestThermalData();
        if (thermalData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(thermalData);
    }

    // Other endpoints as needed
}