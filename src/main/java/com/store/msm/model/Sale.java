package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sale")
@Data
public class Sale {
    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "datetime")
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductSale> productSales = new HashSet<>();
    @Column(name = "total_products")
    private int quantity;
    @Column(name = "total_sale")
    private float total;
}
