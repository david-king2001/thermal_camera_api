package com.example.gaugecluster_api.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="gauge_cluster_data")
@Entity
public class GaugeClusterData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String gaugeClusterId;
    private int speed;
    private int rpm;
    private double fuelLevel;
    private double engineTemperature;

    public GaugeClusterData() {
    }

    public String getGaugeClusterId() {
        return gaugeClusterId;
    }

}
