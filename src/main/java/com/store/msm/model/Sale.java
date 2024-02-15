package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sale")
@Data
public class Sale {
    @Id
    @Column(name = "sale_id")
    private String id;
    @Column(name = "datetime")
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;
    @ManyToMany(mappedBy = "sales")
    private Set<Product> productSales;
}
