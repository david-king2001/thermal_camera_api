package com.example.gaugecluster_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.gaugecluster_api.model.GaugeClusterData;

@Repository
public interface GaugeDataRepo extends JpaRepository<GaugeClusterData, Long> {
    List<GaugeClusterData> findAllByGaugeClusterId(String gaugeClusterId);
}