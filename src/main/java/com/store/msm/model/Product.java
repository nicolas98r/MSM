package com.store.msm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
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
