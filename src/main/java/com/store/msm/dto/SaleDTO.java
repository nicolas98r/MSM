package com.store.msm.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SaleDTO {
    private String id;
    private Date dateTime;
    private String seller;
    private List<ProductDTO> products;
    private int quantity;
    private float total;
}
