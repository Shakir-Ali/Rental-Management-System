package com.shakirali.remintenant.services.impl;

import com.shakirali.remintenant.beans.TenantStatus;
import com.shakirali.remintenant.entity.Tenant;
import com.shakirali.remintenant.repository.TenantRepository;
import com.shakirali.remintenant.services.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public Tenant addTenant(Tenant tenant){
        validations(tenant);
        return tenantRepository.save(tenant);
    }

    private void validations(Tenant tenant) {
        boolean validate = false;
        // Checking Tenant
        if(tenant == null){
            throw new IllegalArgumentException("Tenant cannot be null");
        }
        if(tenantRepository.findByNameAndMobile_No(tenant.getId().getName(), tenant.getId().getMobileNo()) != null) {
            throw new IllegalArgumentException("Tenant already exists");
        }
        // Validating Name and Mobile Number
        if(!tenant.getId().getName().isEmpty() && !tenant.getId().getMobileNo().isEmpty() && tenant.getId().getMobileNo().length() != 10){
            throw new RuntimeException("Enter Valid Name and Mobile Number");
        }
        // Validating Start Date
        if(tenant.getDateOfStart() == null) {
            throw new RuntimeException("Date of start can't be empty");
        }
        // Validating Starting Rent and Updating Current Rent
        if(tenant.getStartingRent() == null || tenant.getStartingRent() <= 0) {
            throw new RuntimeException("Start Rent can't be empty");
        } else if((tenant.getCurrentRent() == null || tenant.getCurrentRent() <= 0)) {
            tenant.setCurrentRent(tenant.getStartingRent());
        }
        // Setting Last Updated Date
        tenant.setLastUpdated(LocalDate.now());
        tenant.setRemainingRent(0.0);
        tenant.setTenantStatus(TenantStatus.ACTIVE);
    }

    @Override
    public Tenant removeTenant(String name, String mobileNo) {
        Tenant tenant = tenantRepository.findByNameAndMobile_No(name, mobileNo);
        if (tenant == null) {
            throw new IllegalArgumentException("Tenant does not exist");
        }
        tenantRepository.delete(tenant);
        return tenant;
    }

    @Override
    public List<Tenant> getAllTenants(){
        List<Tenant> tenants = tenantRepository.findAll();
        return tenants;
    }

    @Override
    public Tenant addMonthlyRent(Tenant tenant) {
        log.info("Adding Monthly Rent");

        tenant.setRemainingRent(tenant.getRemainingRent() + tenant.getCurrentRent());
        tenant = tenantRepository.save(tenant);

        log.info("Monthly Rent Added");

        return tenant;
    }

    @Override
    public Tenant addYearlyRent(Tenant tenant) {
        log.info("Adding Yearly Rent");

        tenant.setCurrentRent(tenant.getCurrentRent() + (tenant.getCurrentRent() * 0.05));
        tenant = tenantRepository.save(tenant);

        log.info("Yearly Rent Added");

        return tenant;
    }

}
