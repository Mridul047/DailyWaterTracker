package com.mcy.watertracker.controller;

import com.mcy.watertracker.model.WhatsAppRequest;
import com.mcy.watertracker.service.TwilioWhatsAppSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwilioController {

  private final TwilioWhatsAppSender twilioWhatsAppSender;

  public TwilioController(TwilioWhatsAppSender twilioWhatsAppSender) {
    this.twilioWhatsAppSender = twilioWhatsAppSender;
  }

  @PostMapping("/v1/remindMe")
  public void sendReminder(@RequestBody WhatsAppRequest whatsAppRequest) {
    twilioWhatsAppSender.sendMessage(whatsAppRequest);
  }
}
