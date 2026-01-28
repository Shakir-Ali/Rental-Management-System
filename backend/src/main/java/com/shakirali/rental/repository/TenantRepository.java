package com.shakirali.rental.repository;

import com.shakirali.rental.entity.Tenant;
import com.shakirali.rental.entity.TenantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, TenantId> {

    @Query(value = "SELECT * from Tenant WHERE name = :name And mobile_no = :mobileNo", nativeQuery = true)
    Tenant findByNameAndMobile_No(String name, String mobileNo);
}
