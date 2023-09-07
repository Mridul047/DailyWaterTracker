package com.mcy.watertracker.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInit {
  private static final Logger log = LoggerFactory.getLogger(TwilioInit.class);

  public TwilioInit(TwilioConfig twilioConfig) {
    Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    log.info("Twilio init. successfully !!");
  }
}
