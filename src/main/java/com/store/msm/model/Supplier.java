package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "supplier")
@Data
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "supplier_name", unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private SupplierType supplierType;
    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> productSuppliers;
}
