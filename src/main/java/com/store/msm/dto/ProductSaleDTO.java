package com.store.msm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSaleDTO {
    private String id;
    private String name;
    private int quantity;
    private float price;
}
