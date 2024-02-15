package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "product_name")
    private String name;
    private String description;
    private int quantity;
    private String model;
    private float price;
    @ManyToMany
    @JoinTable(
            name = "product_sales",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id"))
    private Set<Sale> sales;
    @ManyToMany
    @JoinTable(
            name = "product_suppliers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> suppliers;
}
