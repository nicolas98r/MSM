package com.store.msm.service;

import com.store.msm.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private ISaleRepository repository;
}
