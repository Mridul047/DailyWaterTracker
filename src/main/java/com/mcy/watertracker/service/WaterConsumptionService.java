package com.mcy.watertracker.service;

import com.mcy.watertracker.entity.Person;
import com.mcy.watertracker.entity.WaterConsumption;
import com.mcy.watertracker.model.dto.WaterConsumptionDTO;
import com.mcy.watertracker.respository.PersonRepository;
import com.mcy.watertracker.respository.WaterConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaterConsumptionService {

  @Autowired private WaterConsumptionRepository waterConsumptionRepository;

  @Autowired private PersonRepository personRepository;

  public WaterConsumptionDTO registerWaterConsumption(WaterConsumptionDTO waterConsumptionDTO) {

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
    return new WaterConsumptionDTO();
  }

  // Other service methods for water consumption (e.g., getWaterConsumptionById,
  // updateWaterConsumption, deleteWaterConsumption)

  public List<WaterConsumptionDTO> fetchWaterConsumptionById(Long personId) {
    Pageable firstPageWithTwoElements = PageRequest.of(0, 5);
    var page = waterConsumptionRepository.findAll(firstPageWithTwoElements);
    return page.stream()
        .map(
            waterConsumption -> {
              var waterConsumptionDTO = new WaterConsumptionDTO();
              waterConsumptionDTO.setBrandName(waterConsumption.getBrandName());
              waterConsumptionDTO.setWaterConsumedAt(waterConsumption.getWaterConsumedAt());
              waterConsumptionDTO.setPersonId(waterConsumption.getPerson().getPersonId());
              waterConsumptionDTO.setCapacityConsumedInMl(
                  waterConsumption.getCapacityConsumedInMl());
              return waterConsumptionDTO;
            })
        .collect(Collectors.toList());
  }
}
