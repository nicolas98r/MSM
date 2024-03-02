package com.store.msm.controller;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.ResponseDTO;
import com.store.msm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ResponseDTO response = new ResponseDTO();
    @Autowired
    private ProductService service;


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductDTO dto) {
        service.createProduct(dto);
        response.setMessage("Creado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDTO> updateProduct(@RequestBody ProductDTO dto) {
        service.updateProduct(dto);
        response.setMessage("Actualizado");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestBody ProductDTO dto) {
        service.deleteProduct(dto);
        response.setMessage("Borrado");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/stock/")
    public ResponseEntity<ResponseDTO> updateStorage(@RequestParam(name = "type", required = true) String type, @RequestBody ProductDTO dto) {
        service.updateStorage(dto, type);
        response.setMessage("Actualizado el storage del producto");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
