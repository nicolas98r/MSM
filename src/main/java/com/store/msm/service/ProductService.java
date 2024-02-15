package com.store.msm.service;

import com.store.msm.dto.ProductDTO;
import com.store.msm.mapper.ProductMapper;
import com.store.msm.model.Product;
import com.store.msm.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository repository;

    public Product createProduct(ProductDTO dto) {
        Product product = ProductMapper.convertToEntity(dto);
        return repository.save(product);
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void updateStorage(String id, int value, String operationType) {
        Product product = repository.findById(id).get();
        if (operationType.equals("add")) {

        }
    }
}
