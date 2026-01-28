package com.shakirali.rental.entity;

import com.shakirali.rental.beans.Properties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @Id
    private String name;
    private int mobileNo;

    private Properties property;
    private String notes;

    private LocalDate dateOfStart;
    private Double startingRent;
    private Double currentRent;

}
