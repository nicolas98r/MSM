package com.store.msm.controller;

import com.store.msm.dto.ResponseDTO;
import com.store.msm.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {
    private final ResponseDTO response = new ResponseDTO();
    @Autowired
    private SaleService service;


}
