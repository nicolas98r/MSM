package com.store.msm.mapper;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.SaleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class SaleMapper {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static SaleDTO convertToSale(Date datetime, String seller, List<ProductDTO> products, int quantity, float total) {
        return SaleDTO
                .builder()
                .dateTime(datetime)
                .seller(seller)
                .products(products)
                .quantity(quantity)
                .total(total)
                .build();
    }

}
