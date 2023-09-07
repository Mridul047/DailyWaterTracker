package com.mcy.watertracker.component;

import com.mcy.watertracker.model.WhatsAppRequest;

public interface WhatsAppSender {
    void sendMessage(WhatsAppRequest whatsAppRequest);
}
