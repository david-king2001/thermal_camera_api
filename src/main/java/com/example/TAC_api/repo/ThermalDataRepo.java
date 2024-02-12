package com.example.TAC_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.example.TAC_api.model.ThermalData;

@Repository
public interface ThermalDataRepo extends JpaRepository<ThermalData, Long> {
//    List<ThermalData> findAllByGaugeClusterId(String gaugeClusterId);
    ThermalData findById(long id);
    @Query(value = "SELECT * FROM thermal_data ORDER BY created_at DESC LIMIT 1", nativeQuery = true)
    ThermalData findLatestThermalData();
}