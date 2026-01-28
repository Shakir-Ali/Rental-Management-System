package com.shakirali.rental.entity;

import com.shakirali.rental.beans.Properties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class TenantId implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "mobile_no")
    private String mobileNo;
}
