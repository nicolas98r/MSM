package com.store.msm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sale")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
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
    @Builder.Default
    private int quantity = 0;
    @Column(name = "total_sale")
    @Builder.Default
    private float total = 0;
}
