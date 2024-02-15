package com.store.msm.controller;

import com.store.msm.dto.ProductDTO;
import com.store.msm.dto.ResponseDTO;
import com.store.msm.exceptions.ItemExitsException;
import com.store.msm.exceptions.ItemNotFoundException;
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
    private final ResponseDTO response = new ResponseDTO();
    @Autowired
    private ProductService service;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductDTO dto) {
        String name = dto.getName();
        if (service.findByName(name).isPresent()) {
            throw new ItemExitsException(name);
        }
        Product product = service.createProduct(dto);
        response.setMessage("Creado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDTO> updateProduct(@RequestBody ProductDTO dto) {
        String name = dto.getName();
        if (service.findByName(name).isPresent()) {
            Product product = service.updateProduct(dto);
            response.setMessage("Actualizado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else throw new ItemNotFoundException(name);
    }

    @DeleteMapping("/")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestBody ProductDTO dto) {
        String name = dto.getName();
        if (service.findByName(name).isPresent()) {
            service.deleteByName(name);
            response.setMessage("Borrado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else throw new ItemNotFoundException(name);
    }

    @PutMapping("/stock/")
    public ResponseEntity<ResponseDTO> updateStorage(@RequestParam(name = "type", required = true) String type, @RequestBody ProductDTO dto) {
        String name = dto.getName();
        Optional<Product> product = service.findByName(name);
        if (product.isPresent()) {
            service.updateStorage(product.get(), dto.getQuantity(), type);
            response.setMessage("Actualizado el storage del producto");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else throw new ItemNotFoundException(name);
    }
}
