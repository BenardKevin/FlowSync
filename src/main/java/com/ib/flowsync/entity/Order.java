package com.ib.flowsync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="\"order\"")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false)
    private Contact contact;

    private Date date;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Collection<OrderLine> orderLineList = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Collection<Invoice> invoiceList = new ArrayList<>();
}
