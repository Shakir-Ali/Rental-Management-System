package com.shakirali.rental.controller;

import com.shakirali.rental.beans.Properties;
import com.shakirali.rental.beans.RentStatus;
import com.shakirali.rental.entity.Tenant;
import com.shakirali.rental.entity.TenantId;
import com.shakirali.rental.services.impl.WhatsAppNotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    WhatsAppNotificationServiceImpl notificationService;

    @GetMapping(value = "/sendNotification")
    public ResponseEntity<String> testSendNotification() {
        notificationService.sendMessage("Hello", "1234567890");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
