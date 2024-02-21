package com.store.msm.repository;

import com.store.msm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.quantity = :quantity WHERE p.id = :id")
    void updateProductStorageById(@Param("id") String id, @Param("quantity") Integer quantity);
}
