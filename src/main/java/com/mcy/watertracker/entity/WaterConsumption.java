package com.mcy.watertracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime; // Import LocalDateTime

@Entity
public class WaterConsumption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long resourceId;

  private String brandName;

  private LocalDateTime waterConsumedAt; // Change the data type to LocalDateTime

  private int capacityConsumedInMl;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;

  // Constructors, getters, setters, and other methods

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public LocalDateTime getWaterConsumedAt() { // Change the return type
    return waterConsumedAt;
  }

  public void setWaterConsumedAt(LocalDateTime waterConsumedAt) { // Change the parameter type
    this.waterConsumedAt = waterConsumedAt;
  }

  public int getCapacityConsumedInMl() {
    return capacityConsumedInMl;
  }

  public void setCapacityConsumedInMl(int capacityConsumedInMl) {
    this.capacityConsumedInMl = capacityConsumedInMl;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}

