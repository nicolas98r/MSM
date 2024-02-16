package com.store.msm.mapper;

import com.store.msm.dto.SaleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class SaleMapper {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static SaleDTO convertToSale(String seller, int quantity, float totalSale) {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSeller(seller);
        saleDTO.setQuantity(quantity);
        saleDTO.setTotal(totalSale);
        return saleDTO;
    }

}
