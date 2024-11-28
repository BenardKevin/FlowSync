package com.ib.flowsync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles = new ArrayList<>();

    public Privilege() { }

    public Privilege(String name) {
        this.name = name;
    }
}