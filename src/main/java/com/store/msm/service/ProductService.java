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

@Service
public class ProductService {

    @Autowired
    private IProductRepository repository;

    public void createProduct(ProductDTO dto) {
        if (repository.findByName(dto.getName()).isPresent()) throw new ItemExitsException(dto.getName());
        Product product = ProductMapper.convertToEntity(dto);
        repository.save(product);
    }

    public Product findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ItemNotFoundException(name));
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

    public void updateStorage(Product product, int value, String operationType) {
        int stock = product.getQuantity();
        if (operationType.equals("add")) {
            stock += value;
        } else if (operationType.equals("delete")) {
            if (stock >= value) {
                stock -= value;
            } else throw new StockException();
        }
        repository.updateProductQuantityById(product.getId(), stock);
    }
}
