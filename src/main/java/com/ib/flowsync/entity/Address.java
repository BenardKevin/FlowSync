package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Address implements Serializable {

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
