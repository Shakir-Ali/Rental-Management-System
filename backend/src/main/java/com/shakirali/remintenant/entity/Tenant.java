package com.shakirali.remintenant.entity;

import com.shakirali.remintenant.beans.Properties;
import com.shakirali.remintenant.beans.RentStatus;
import com.shakirali.remintenant.beans.TenantStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tenants")
public class Tenant {

    @EmbeddedId
    private TenantId id;

    @Enumerated(EnumType.STRING)
    private Properties property;
    @Enumerated(EnumType.STRING)
    private RentStatus rentStatus;
    @Enumerated(EnumType.STRING)
    private TenantStatus tenantStatus;
    private String notes;

    private LocalDate dateOfStart;
    private Double startingRent;
    private Double currentRent;
    private Double remainingRent;

    private LocalDate lastUpdated;
}
