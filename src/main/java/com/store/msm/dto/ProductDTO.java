package com.store.msm.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private float id;
    private String name;
    private String description;
    private int quantity;
    private String model;
    private int price;
}
