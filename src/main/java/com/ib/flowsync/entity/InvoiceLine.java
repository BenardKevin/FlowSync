package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class InvoiceLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @ManyToOne
//    private Integer invoiceId;

    @ManyToOne
    private Invoice invoice;

    private Integer quantity;
    private Product product;
}
