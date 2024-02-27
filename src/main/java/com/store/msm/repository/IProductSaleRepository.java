package com.store.msm.repository;

import com.store.msm.model.ProductSale;
import com.store.msm.model.ProductSaleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductSaleRepository extends JpaRepository<ProductSale, ProductSaleId> {

    @Transactional
    @Query(value = "SELECT pr.product_id, pr.product_name, ps.quantity, ps.price FROM product_sale ps " +
            "INNER JOIN product pr ON pr.product_id = ps.product_id WHERE ps.sale_id = :sale_id",
            nativeQuery = true
    )
    List<Object[]> findProductsFromSale(@Param("sale_id") String saleId);
}
