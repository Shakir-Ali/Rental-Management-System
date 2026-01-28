package com.shakirali.rental.repository;

import com.shakirali.rental.entity.Tenant;
import com.shakirali.rental.entity.TenantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, TenantId> {

    Tenant findByNameAndMobile_No(String name, String mobileNo);
}
