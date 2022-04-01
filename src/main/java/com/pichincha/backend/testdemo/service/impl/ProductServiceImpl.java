package com.pichincha.backend.testdemo.service.impl;

import com.pichincha.backend.testdemo.model.Product;
import com.pichincha.backend.testdemo.repository.ProductRepository;
import com.pichincha.backend.testdemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
