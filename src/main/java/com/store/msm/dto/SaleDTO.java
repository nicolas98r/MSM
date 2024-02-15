package com.store.msm.dto;

import lombok.Data;

import java.util.List;

@Data
public class SaleDTO {
    private List<ProductDTO> products;
}
