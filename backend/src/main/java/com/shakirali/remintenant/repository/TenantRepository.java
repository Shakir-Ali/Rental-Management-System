package com.shakirali.remintenant.repository;

import com.shakirali.remintenant.beans.TenantStatus;
import com.shakirali.remintenant.entity.Tenant;
import com.shakirali.remintenant.entity.TenantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, TenantId> {

    @Query(value = "SELECT * from Tenants WHERE name = :name And mobile_no = :mobileNo", nativeQuery = true)
    Tenant findByNameAndMobile_No(String name, String mobileNo);

    List<Tenant> findByRemainingRentGreaterThan(Double amount);

    List<Tenant> findByTenantStatus(TenantStatus tenantStatus);
}
