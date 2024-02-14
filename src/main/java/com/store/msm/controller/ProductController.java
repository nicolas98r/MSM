package com.store.msm.controller;

import com.store.msm.dto.ProductDTO;
import com.store.msm.model.Product;
import com.store.msm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Pong", HttpStatus.OK);
    }

    @PostMapping("/create/")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            Product _product = service.createProduct(productDTO);
            return new ResponseEntity<>("Creado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
