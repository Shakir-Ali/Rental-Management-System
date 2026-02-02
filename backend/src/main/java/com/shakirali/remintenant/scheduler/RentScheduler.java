package com.shakirali.remintenant.scheduler;

import com.shakirali.remintenant.beans.TenantStatus;
import com.shakirali.remintenant.entity.Tenant;
import com.shakirali.remintenant.repository.TenantRepository;
import com.shakirali.remintenant.services.NotificationService;
import com.shakirali.remintenant.services.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class RentScheduler {

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private TenantService tenantService;

    @Scheduled(cron = "0 0 8 * * ?")
    public void monthlyRentSchedule(){
        log.info("Running Monthly Rent Scheduler");
        List<Tenant> activeTenants = tenantRepository.findByTenantStatus(TenantStatus.ACTIVE);
        log.info("Active Tenants: {}", activeTenants);
        for (Tenant tenant : activeTenants) {
            log.info("Active Tenant: {}", tenant);
            log.info("DayOfMonth: {}", tenant.getDateOfStart().getDayOfMonth());
            if(tenant.getDateOfStart().getDayOfMonth() == LocalDate.now().getDayOfMonth()){
                Tenant updatedTenant = tenantService.addMonthlyRent(tenant);
                String message = buildMessage(updatedTenant);
                notificationService.sendMessage(message, updatedTenant.getId().getMobileNo());
            }
        }
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void yearlyRentSchedule(){
        log.info("Running Yearly Rent Scheduler");
        List<Tenant> activeTenants = tenantRepository.findByTenantStatus(TenantStatus.ACTIVE);
        for (Tenant tenant : activeTenants) {
            if(tenant.getDateOfStart().getDayOfMonth() == LocalDate.now().getDayOfMonth() && tenant.getDateOfStart().getMonthValue() == LocalDate.now().getMonthValue()){
                Tenant updatedTenant = tenantService.addYearlyRent(tenant);
                String message = buildMessage(updatedTenant);
                notificationService.sendMessage(message, updatedTenant.getId().getMobileNo());
            }
        }
    }

    private String buildMessage(Tenant tenant) {
        return String.format("Reminder: Your rent balance of ₹%.2f is due. For the month of", tenant.getRemainingRent());
    }

}
