package com.store.msm.service;

import com.store.msm.dto.ProductDTO;
import com.store.msm.mapper.ProductMapper;
import com.store.msm.model.Product;
import com.store.msm.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository repository;

    public Product createProduct(ProductDTO dto) {
        Product product = ProductMapper.convertToEntity(dto);
        return repository.save(product);
    }
}
