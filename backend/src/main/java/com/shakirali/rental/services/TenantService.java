package com.shakirali.rental.services;

import com.shakirali.rental.entity.Tenant;

import java.util.List;

public interface TenantService {

    Tenant addTenant(Tenant tenant);
    Tenant removeTenant(String name, String mobileNo);
    List<Tenant> getAllTenants();
    Tenant addMonthlyRent(Tenant tenant);
    Tenant addYearlyRent(Tenant tenant);

}
