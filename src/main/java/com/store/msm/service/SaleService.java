package com.store.msm.service;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.SaleDTO;
import com.store.msm.model.Product;
import com.store.msm.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private ISaleRepository repository;

    @Autowired
    private ProductService productService;

    public SaleDTO sellProducts(SaleDTO dto) {
        SaleDTO response = new SaleDTO();
        Product product;
        int totalProducts = 0;
        float totalSale = 0;
        List<ProductDTO> products = dto.getProducts();
        for (ProductDTO currentProduct : products) {
            // Obtiene toda la información del producto para calcular lo que falta
            product = productService.findByName(currentProduct.getName());
            //Actualiza el storage del producto
            productService.updateStorage(product, currentProduct.getQuantity(), "delete");
            totalProducts += currentProduct.getQuantity();
            totalSale += product.getPrice() * totalProducts;
        }
        response.setSeller(dto.getSeller());
        response.setTotalProducts(totalProducts);
        response.setTotalSale(totalSale);
        return response;
    }
}
