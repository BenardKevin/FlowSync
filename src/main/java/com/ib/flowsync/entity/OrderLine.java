package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false)
    private Order order;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    private Product product;
}
