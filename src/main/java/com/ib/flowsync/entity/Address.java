package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer streetNumber;

    @Column(nullable = false)
    private String streetName;

    private Integer zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;
}
