package com.store.msm.controller;

import com.store.msm.dto.ProductDTO;
import com.store.msm.model.Product;
import com.store.msm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductService service;


    @GetMapping("/")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Pong", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO dto) {
        try {
            Product _product = service.createProduct(dto);
            return new ResponseEntity<>("Creado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:\n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> updateProduct(@RequestParam(required = true, name = "id") String product_id, @RequestBody ProductDTO dto) {
        Optional<Product> _product = service.findById(product_id);
        if (_product.isPresent()) {
            dto.setId(product_id);
            Product product = service.createProduct(dto);
            return new ResponseEntity<>("Actualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteProduct(@RequestParam(required = true, name = "id") String product_id) {
        try {
            service.deleteById(product_id);
            return new ResponseEntity<>("Borrado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:\n" + e, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
