package com.shakirali.rental.services.impl;

import com.shakirali.rental.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WhatsAppNotificationServiceImpl implements NotificationService {

    @Override
    public void sendMessage(String message, String mobileNo) {
        log.info("Sending notification to " + mobileNo + ":" + message);
    }
}
