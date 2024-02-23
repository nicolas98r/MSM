package com.store.msm.repository;

import com.store.msm.model.ProductSale;
import com.store.msm.model.ProductSaleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductSaleRepository extends JpaRepository<ProductSale, ProductSaleId> {
}
