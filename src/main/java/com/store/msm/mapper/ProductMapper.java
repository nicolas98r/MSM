package com.store.msm.mapper;

import com.store.msm.dto.ProductDTO;
import com.store.msm.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper{
    @Autowired
    private static ModelMapper modelMapper;
    public static ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
