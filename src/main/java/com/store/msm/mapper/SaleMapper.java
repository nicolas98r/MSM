package com.store.msm.mapper;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.SaleDTO;
import com.store.msm.model.Sale;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
public class SaleMapper {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static SaleDTO convertToDTO(Sale sale, List<ProductDTO> products) {
        SaleDTO dto = modelMapper.map(sale, SaleDTO.class);
        dto.setSeller(sale.getSeller().getUsername());
        dto.setProducts(products);
        return dto;
    }

}
