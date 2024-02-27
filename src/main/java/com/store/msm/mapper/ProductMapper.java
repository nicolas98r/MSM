package com.store.msm.mapper;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.ProductSaleDTO;
import com.store.msm.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductMapper {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public static ProductDTO convertToDTO(ProductSaleDTO dto) {
        return modelMapper.map(dto, ProductDTO.class);
    }

    public static List<ProductSaleDTO> covertToProductSaleDTOS(List<Object[]> products) {
        return products.stream().map(ProductMapper::covertToProductSaleDTO).toList();
    }

    private static ProductSaleDTO covertToProductSaleDTO(Object[] product) {
        return new ProductSaleDTO((String) product[0], (String) product[1], (Integer) product[2], (Float) product[3]);
    }
}
