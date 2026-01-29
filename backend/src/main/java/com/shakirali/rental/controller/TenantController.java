package com.shakirali.rental.controller;

import com.shakirali.rental.beans.Properties;
import com.shakirali.rental.beans.RentStatus;
import com.shakirali.rental.entity.Tenant;
import com.shakirali.rental.entity.TenantId;
import com.shakirali.rental.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    TenantService tenantService;

    @GetMapping(value = "/getAllTenants")
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantService.getAllTenants();
        if (tenants.isEmpty()) {
            return new ResponseEntity<>(tenants, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tenants, HttpStatus.OK);
    }

    @PostMapping(value = "/addTenant")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
        Tenant savedTenant = tenantService.addTenant(tenant);
        if (savedTenant == null) {
            return new ResponseEntity<>(savedTenant, HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(savedTenant, HttpStatus.CREATED);
    }

    @GetMapping(value = "/testAddTenant")
    public ResponseEntity<Tenant> testAddTenant() {
        Tenant tenant = new Tenant();
        tenant.setId(new TenantId());
        tenant.getId().setName("Shakir");
        tenant.getId().setMobileNo("1234567890");
        tenant.setProperty(Properties.FAZAL_PLAZA);
        tenant.setRentStatus(RentStatus.PAID);
        tenant.setLastUpdated(LocalDate.now());
        tenant.setStartingRent(4500.0);
        tenant.setDateOfStart(LocalDate.now());

        Tenant savedTenant = tenantService.addTenant(tenant);
        if (savedTenant == null) {
            return new ResponseEntity<>(savedTenant, HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(savedTenant, HttpStatus.CREATED);
    }

}
