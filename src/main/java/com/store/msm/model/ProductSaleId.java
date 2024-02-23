package com.store.msm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProductSaleId implements Serializable {
    @Column(name = "product_id")
    private String productId;
    @Column(name = "sale_id")
    private String saleId;
}
