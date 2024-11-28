package com.ib.flowsync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, scale = 2)
    private Float price;

    @Column(nullable = false, scale = 2)
    private Float vat;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;

}
