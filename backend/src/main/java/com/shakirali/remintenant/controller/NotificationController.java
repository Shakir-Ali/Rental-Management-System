package com.shakirali.remintenant.controller;

import com.shakirali.remintenant.services.impl.WhatsAppNotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    WhatsAppNotificationServiceImpl notificationService;

    @GetMapping(value = "/sendNotification")
    public String testSendNotification() {
        notificationService.sendMessage("Hello, My WhatsApp Service is configured", "7690078185");
        return "Sent";
    }

}
