package com.example.gaugecluster_api.dto;

import lombok.Data;

@Data
public class GaugeClusterDataDTO {

    private String gaugeClusterId;
    private int speed;
    private int rpm;
    private double fuelLevel;
    private double engineTemperature;
}