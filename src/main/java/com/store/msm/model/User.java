package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "client")
@Data
public class User {
    @Id
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private UserType userType;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Audit> auditLogs;
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Sale> sales;
}
