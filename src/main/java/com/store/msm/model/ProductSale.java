package com.store.msm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_sale")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductSale {
    @EmbeddedId
    @Builder.Default
    private ProductSaleId id = new ProductSaleId();
    private int quantity;
    private float price;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private Sale sale;
}
