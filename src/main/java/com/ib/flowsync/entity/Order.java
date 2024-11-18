package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="\"order\"")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @ManyToOne
//    private Integer clientId;

    @ManyToOne
    private Contact contact;

    private Date date;

    @OneToMany
    private List<OrderLine> orderLineList = new ArrayList<>();

    @OneToMany
    private List<Invoice> invoiceList = new ArrayList<>();
}
