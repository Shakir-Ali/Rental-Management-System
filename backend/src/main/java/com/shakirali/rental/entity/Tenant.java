package com.shakirali.rental.entity;

import com.shakirali.rental.beans.Properties;
import com.shakirali.rental.beans.RentStatus;
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
    private RentStatus status;
    private String notes;

    private LocalDate dateOfStart;
    private Double startingRent;
    private Double currentRent;
    private Double remainingRent;

    private LocalDate lastUpdated;
}
