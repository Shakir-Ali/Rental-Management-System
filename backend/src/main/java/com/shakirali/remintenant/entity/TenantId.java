package com.shakirali.remintenant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class TenantId implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "mobile_no")
    private String mobileNo;
}
