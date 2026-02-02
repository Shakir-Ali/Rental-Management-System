package com.shakirali.remintenant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Tenant tenant;
    private double amount;
    private LocalDate paymentDate;
}
