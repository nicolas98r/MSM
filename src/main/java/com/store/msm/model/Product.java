package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String name;
    private String description;
    private int quantity;
    private String model;
    private float price;
}
