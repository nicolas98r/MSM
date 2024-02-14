package com.store.msm.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private String model;
    private float price;
}
