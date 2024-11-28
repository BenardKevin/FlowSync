package com.ib.flowsync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Order order;

    private Date date;

    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    private Collection<InvoiceLine> invoiceLineList = new ArrayList<>();
}
