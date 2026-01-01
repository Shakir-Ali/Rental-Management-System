package com.shakirali.rental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String type;

    @Column(nullable = false)
    private Integer monthlyRent;

    @Column(nullable = false)
    private int dueDay;
}
