package com.example.TAC_api.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name="thermal_data")
@Entity
public class ThermalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float[] thermalData;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public ThermalData() {
        thermalData = new float[768];
    }

    public void setThermalData(float[] thermalData){
        System.out.print("setThermalData ");
        System.out.println(thermalData[500]);
        System.arraycopy(thermalData, 0, this.thermalData,0,thermalData.length);
    }
    public float[] getThermalData() {
        return thermalData;
    }
}
