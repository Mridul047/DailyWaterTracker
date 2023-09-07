package com.mcy.watertracker.controller;

import com.mcy.watertracker.model.dto.PersonDTO;
import com.mcy.watertracker.model.dto.WaterConsumptionDTO;
import com.mcy.watertracker.service.PersonService;
import com.mcy.watertracker.service.WaterConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @Autowired private PersonService personService;
  @Autowired private WaterConsumptionService waterConsumptionService;

  @PostMapping("/registerPerson")
  public PersonDTO registerPerson(@RequestBody PersonDTO person) {
    return personService.registerPerson(person);
  }

  @PostMapping("/registerWater")
  public WaterConsumptionDTO registerWaterConsumption(
      @RequestBody WaterConsumptionDTO waterConsumption) {
    return waterConsumptionService.registerWaterConsumption(waterConsumption);
  }
}
