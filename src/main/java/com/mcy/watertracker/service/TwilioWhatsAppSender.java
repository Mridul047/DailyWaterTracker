package com.mcy.watertracker.service;

import com.mcy.watertracker.model.WhatsAppRequest;
import com.mcy.watertracker.component.WhatsAppSender;
import com.mcy.watertracker.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwilioWhatsAppSender implements WhatsAppSender {
  private static final Logger log = LoggerFactory.getLogger(TwilioWhatsAppSender.class);

  private final TwilioConfig twilioConfig;

  public TwilioWhatsAppSender(TwilioConfig twilioConfig) {
    this.twilioConfig = twilioConfig;
  }

  @Override
  public void sendMessage(WhatsAppRequest whatsAppRequest) {

    Message message =
        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + whatsAppRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("whatsapp:" + twilioConfig.getTrailNumber()),
                whatsAppRequest.getMessage())
            .create();
    log.info("Message info: " + message.toString());
  }
}
