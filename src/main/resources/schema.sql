--CREATE TABLE gauge_cluster_data (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    gauge_cluster_id VARCHAR(255) NOT NULL,
--    speed INT,
--    rpm INT,
--    fuel_level DOUBLE,
--    engine_temperature DOUBLE,
--    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--);
CREATE TABLE thermal_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    thermal_data FLOAT[],
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);