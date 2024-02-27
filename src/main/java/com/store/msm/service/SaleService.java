package com.store.msm.service;

import com.store.msm.dto.ProductSaleDTO;
import com.store.msm.dto.SaleDTO;
import com.store.msm.mapper.ProductMapper;
import com.store.msm.mapper.SaleMapper;
import com.store.msm.model.Product;
import com.store.msm.model.ProductSale;
import com.store.msm.model.Sale;
import com.store.msm.repository.IProductSaleRepository;
import com.store.msm.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    public List<SaleDTO> getSalesFromSeller(SaleDTO dto) {
        return saleRepository.findBySellerUsername(dto.getSeller())
                .stream()
                .map(sale -> SaleMapper.convertToDTO(sale, this.getProductsFromSale(sale.getId())))
                .toList();
    }

    private List<ProductSaleDTO> getProductsFromSale(String saleId) {
        return ProductMapper.covertToProductSaleDTOS(productSaleRepository.findProductsFromSale(saleId));
    }


    public SaleDTO sellProducts(SaleDTO dto) {
        Sale sale = Sale.builder()
                .id(UUID.randomUUID().toString())
                .seller(userService.findByUsername(dto.getSeller()))
                .dateTime(new Date())
                .build();
        int totalProducts = 0;
        float totalSale = 0;
        List<ProductSale> productSales = new ArrayList<>();

        List<ProductSaleDTO> products = dto.getProducts();
        for (ProductSaleDTO currentProduct : products) {
            // Obtiene toda la información del producto para calcular lo que falta
            Product product = productService.findByName(currentProduct.getName());
            //Actualiza el storage del producto
            productService.updateStorage(ProductMapper.convertToDTO(currentProduct), "delete");
            // Calcula cantidades y costo por producto
            int quantity = currentProduct.getQuantity();
            float cost = product.getPrice() * quantity;
            currentProduct.setId(product.getId());
            currentProduct.setPrice(cost);
            //Aumenta total productos y ventas
            totalProducts += quantity;
            totalSale += cost;
            // Guarda registro de la venta
            ProductSale productSale = ProductSale
                    .builder()
                    .sale(sale)
                    .product(product)
                    .quantity(quantity)
                    .price(cost)
                    .build();
            productSales.add(productSale);
        }

        //Genera nueva venta y guardado en repositorio
        sale.setQuantity(totalProducts);
        sale.setTotal(totalSale);
        saleRepository.save(sale);
        productSaleRepository.saveAll(productSales);

        return SaleMapper.convertToDTO(sale, products);
    }
}
