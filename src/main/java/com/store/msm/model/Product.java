package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "product_name", unique = true)
    private String name;
    private String description;
    @Column(name = "storage")
    private int quantity;
    private String model;
    private float price;
    @ManyToMany(mappedBy = "products")
    private Set<Sale> productSales = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "product_suppliers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> suppliers;
}
