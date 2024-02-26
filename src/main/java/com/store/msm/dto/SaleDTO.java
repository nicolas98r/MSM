package com.store.msm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDTO {
    private String id;
    private Date dateTime;
    private String seller;
    private List<ProductDTO> products;
    private int quantity;
    private float total;
}
