package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @ManyToOne
//    private Integer orderId;

    @ManyToOne
    private Order order;

    private Date date;

    @OneToMany
    private List<InvoiceLine> invoiceLineList = new ArrayList<>();
}
