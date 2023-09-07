package com.mcy.watertracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WhatsAppRequest {
  private final String phoneNumber;
  private final String message;

  @Override
  public String toString() {
    return "WhatsAppRequest{"
        + "phoneNumber='"
        + phoneNumber
        + '\''
        + ", message='"
        + message
        + '\''
        + '}';
  }
}
