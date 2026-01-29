package com.shakirali.rental.services.impl;

import com.shakirali.rental.services.NotificationService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@Slf4j
public class WhatsAppNotificationServiceImpl implements NotificationService {

    @Value("${twilio.whatsapp.from}")
    private String from;

    @Override
    public void sendMessage(String message, String mobileNo) {
        Message.creator(
                new PhoneNumber("whatsapp:+" + mobileNo),
                new PhoneNumber(from),
                message
        ).create();

        log.info("WhatsApp sent to {}", mobileNo);
    }
}
