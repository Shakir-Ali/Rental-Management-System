package com.shakirali.rental.scheduler;

import com.shakirali.rental.entity.Tenant;
import com.shakirali.rental.repository.TenantRepository;
import com.shakirali.rental.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationScheduler {

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendDailyDueNotifications(){
        log.info("Running Notification Scheduler");
        List<Tenant> dueTenants = tenantRepository.findByRemainingRentGreaterThan(0.0);
        for (Tenant tenant : dueTenants) {
            String message = buildMessage(tenant);

            notificationService.sendMessage(message, tenant.getId().getMobileNo());
        }
    }

    private String buildMessage(Tenant tenant) {
        return String.format("Reminder: Your rent balance of ₹%.2f is due.", tenant.getRemainingRent());
    }

}
