package com.mcy.watertracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterbotApplication {

  public static void main(String[] args) {
    try {
      SpringApplication.run(WaterbotApplication.class, args);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
