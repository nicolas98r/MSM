package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "supplier_type")
@Data
public class SupplierType {
    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type_name", unique = true)
    private String name;
    @OneToMany(mappedBy = "supplierType", cascade = CascadeType.ALL)
    private Set<Supplier> suppliers;
}
