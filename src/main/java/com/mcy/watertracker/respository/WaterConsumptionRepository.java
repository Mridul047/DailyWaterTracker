package com.mcy.watertracker.respository;

import com.mcy.watertracker.entity.WaterConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterConsumptionRepository extends JpaRepository<WaterConsumption, Long> {}
