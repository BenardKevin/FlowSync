package com.ib.flowsync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String firstname;
    private String address;
    private String email;

    @OneToMany
    private List<Order> orderList = new ArrayList<>();
}
