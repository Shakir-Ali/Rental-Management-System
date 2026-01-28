package com.shakirali.rental.services;

import com.shakirali.rental.entity.Tenant;

import java.util.List;

public interface TenantService {

    public Tenant addTenant(Tenant tenant);
    public Tenant removeTenant(String name, String mobileNo);
    public List<Tenant> getAllTenants();

}
