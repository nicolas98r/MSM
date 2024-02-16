package com.store.msm.service;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.SaleDTO;
import com.store.msm.mapper.SaleMapper;
import com.store.msm.model.Product;
import com.store.msm.model.Sale;
import com.store.msm.model.User;
import com.store.msm.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private ISaleRepository repository;

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    public SaleDTO sellProducts(SaleDTO dto) {
        Date currrentDate = new Date();
        Product product = null;
        Sale sale = new Sale();
        User seller;
        int quantity = 0, totalProducts = 0;
        float cost = 0, totalSale = 0;
        List<ProductDTO> products = dto.getProducts();
        for (ProductDTO currentProduct : products) {
            // Obtiene toda la información del producto para calcular lo que falta
            product = productService.findByName(currentProduct.getName());
            //Actualiza el storage del producto
            productService.updateStorage(product, currentProduct.getQuantity(), "delete");
            quantity += currentProduct.getQuantity();
            cost += product.getPrice() * quantity;
            System.out.println(cost);
            totalProducts += quantity;
            totalSale += cost;
            sale.getProducts().add(product);
            quantity = 0;
            cost = 0;
        }

        //Registrar venta en tabla
        seller = userService.findByUsername(dto.getSeller());
        sale.setSeller(seller);
        sale.setDateTime(currrentDate);

        repository.save(sale);


        return SaleMapper.convertToSale(seller.getUsername(), totalProducts, totalSale);

    }
}
