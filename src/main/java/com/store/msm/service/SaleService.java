package com.store.msm.service;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.SaleDTO;
import com.store.msm.mapper.SaleMapper;
import com.store.msm.model.Product;
import com.store.msm.model.ProductSale;
import com.store.msm.model.Sale;
import com.store.msm.repository.IProductSaleRepository;
import com.store.msm.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private IProductSaleRepository productSaleRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    public SaleDTO sellProducts(SaleDTO dto) {
        Date currrentDate = new Date();
        Sale sale = new Sale();
        int totalProducts = 0;
        float totalSale = 0;

        //Genera nueva venta
        sale.setSeller(userService.findByUsername(dto.getSeller()));
        sale.setDateTime(currrentDate);
        saleRepository.save(sale);

        List<ProductDTO> products = dto.getProducts();
        for (ProductDTO currentProduct : products) {
            // Obtiene toda la información del producto para calcular lo que falta
            Product product = productService.findByName(currentProduct.getName());
            //Actualiza el storage del producto
            productService.updateStorage(currentProduct, "delete");
            // Calcula cantidades y costo por producto
            int quantity = currentProduct.getQuantity();
            float cost = product.getPrice() * quantity;
            //Aumenta total productos y ventas
            totalProducts += quantity;
            totalSale += cost;
            // Guarda registro de la venta
            ProductSale productSale = new ProductSale();
            productSale.setSale(sale);
            productSale.setProduct(product);
            productSale.setQuantity(quantity);
            productSale.setPrice(cost);

            productSaleRepository.save(productSale);

        }

        sale.setQuantity(totalProducts);
        sale.setTotal(totalSale);
        saleRepository.save(sale);

        return SaleMapper.convertToSale(sale.getSeller().getUsername(), totalProducts, totalSale);

    }
}
