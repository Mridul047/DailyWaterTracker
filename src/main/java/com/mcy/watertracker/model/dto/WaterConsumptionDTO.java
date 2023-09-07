package com.mcy.watertracker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterConsumptionDTO {
  private String brandName;
  private LocalDateTime waterConsumedAt;
  private int capacityConsumedInMl;
  private Long personId; // to associate the water consumption with a person

  // Constructors, getters, setters
}
