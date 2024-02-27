package com.store.msm.repository;

import com.store.msm.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, String> {
    List<Sale> findBySellerUsername(String username);
}
