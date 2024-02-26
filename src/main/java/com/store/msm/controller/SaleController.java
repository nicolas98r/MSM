package com.store.msm.controller;

import com.store.msm.dto.ResponseDTO;
import com.store.msm.dto.SaleDTO;
import com.store.msm.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {
    private final ResponseDTO response = new ResponseDTO();
    @Autowired
    private SaleService service;

    @PostMapping("/")
    public ResponseEntity<SaleDTO> sellProducts(@RequestBody SaleDTO dto) {
        SaleDTO sale = service.sellProducts(dto);
        response.setMessage("Producto vendido");
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }


}
