package com.mcy.watertracker.service;

import com.mcy.watertracker.entity.Person;
import com.mcy.watertracker.entity.WaterConsumption;
import com.mcy.watertracker.model.dto.WaterConsumptionDTO;
import com.mcy.watertracker.respository.PersonRepository;
import com.mcy.watertracker.respository.WaterConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WaterConsumptionService {

  @Autowired private WaterConsumptionRepository waterConsumptionRepository;

  @Autowired private PersonRepository personRepository;

  public WaterConsumptionDTO registerWaterConsumption(WaterConsumptionDTO waterConsumptionDTO) {

    try {
      WaterConsumption waterConsumption = new WaterConsumption();
      waterConsumption.setBrandName(waterConsumptionDTO.getBrandName());
      waterConsumption.setWaterConsumedAt(LocalDateTime.now());
      waterConsumption.setCapacityConsumedInMl(waterConsumptionDTO.getCapacityConsumedInMl());

      // Fetch the associated person from the database or use the personId in DTO to set the
      // association
      Person person = personRepository.findById(waterConsumptionDTO.getPersonId()).orElse(null);
      if (person != null) {
        waterConsumption.setPerson(person);
        var updatedWCR = waterConsumptionRepository.save(waterConsumption);
        return new WaterConsumptionDTO(
            updatedWCR.getBrandName(),
            updatedWCR.getWaterConsumedAt(),
            updatedWCR.getCapacityConsumedInMl(),
            updatedWCR.getPerson().getPersonId());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  // Other service methods for water consumption (e.g., getWaterConsumptionById,
  // updateWaterConsumption, deleteWaterConsumption)
}
