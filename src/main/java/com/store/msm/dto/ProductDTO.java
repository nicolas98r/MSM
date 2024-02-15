package com.store.msm.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private int quantity;
    private String model;
    private float price;
}
