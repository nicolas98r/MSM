package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float id;
    private String name;
    private String description;
    private int quantity;
    private String model;
    private int price;
}