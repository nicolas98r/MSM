package com.store.msm.service;

import com.store.msm.dto.ProductDTO;
import com.store.msm.exceptions.ItemExitsException;
import com.store.msm.exceptions.ItemNotFoundException;
import com.store.msm.exceptions.StockException;
import com.store.msm.mapper.ProductMapper;
import com.store.msm.model.Product;
import com.store.msm.repository.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private IProductRepository repository;


    public ProductDTO getProductById(String id) {
        Product product = this.findById(id);
        return ProductMapper.convertToDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(ProductMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public void createProduct(ProductDTO dto) {
        if (repository.findByName(dto.getName()).isPresent()) throw new ItemExitsException(dto.getName());
        Product product = ProductMapper.convertToEntity(dto);
        repository.save(product);
    }

    public void updateProduct(ProductDTO dto) {
        Product product = this.findByName(dto.getName());
        BeanUtils.copyProperties(dto, product, "id", "product_name");
        repository.save(product);
    }

    public void deleteProduct(ProductDTO dto) {
        Product product = this.findByName(dto.getName());
        repository.delete(product);
    }

    public void updateStorage(ProductDTO dto, String operationType) {
        Product product = this.findByName(dto.getName());
        int value = dto.getQuantity();
        int stock = product.getQuantity();
        if (operationType.equals("add")) {
            stock += value;
        } else if (operationType.equals("delete")) {
            if (stock >= value) {
                stock -= value;
            } else throw new StockException();
        }
        repository.updateProductStorageById(product.getId(), stock);
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Product findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ItemNotFoundException(name));
    }
}
