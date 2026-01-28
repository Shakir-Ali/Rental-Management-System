package com.shakirali.rental.entity;

import com.shakirali.rental.beans.RentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(
        name = "rents",
uniqueConstraints = @UniqueConstraint(columnNames = {"tenant_id", "month", "year"}))
public class RentDeposit {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Tenant tenant;

    private double amount;

    @Enumerated(EnumType.STRING)
    private RentStatus status;

    private LocalDate paymentDate;


}
