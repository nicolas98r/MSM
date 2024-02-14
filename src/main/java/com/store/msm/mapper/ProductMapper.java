package com.store.msm.mapper;

import com.store.msm.dto.ProductDTO;
import com.store.msm.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Data
@NoArgsConstructor
public class ProductMapper{
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
