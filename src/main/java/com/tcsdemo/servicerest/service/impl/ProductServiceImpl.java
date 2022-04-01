package com.tcsdemo.servicerest.service.impl;

import com.tcsdemo.servicerest.dto.ProductDto;
import com.tcsdemo.servicerest.exception.ProductException;
import com.tcsdemo.servicerest.model.Product;
import com.tcsdemo.servicerest.repository.ProductRepository;
import com.tcsdemo.servicerest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProducts() {
        ArrayList<ProductDto> productsDto = new ArrayList<ProductDto>();

        productRepository.findAll()
                .forEach(product -> {
                    productsDto.add(product.getAsDto());
                });

        return productsDto;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return productRepository.save(productDto.getAsEntity()).getAsDto();
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) throws ProductException {

        Product productBdd = productRepository.findById(id).orElse(null);

        if (productBdd == null )
            throw new ProductException("No exists");

        productBdd.setName( productDto.getName() );
        productBdd.setDescription( productDto.getDescription() );
        productBdd.setSize( productDto.getSize() );

        return productRepository.save(productBdd).getAsDto();
    }

    @Override
    public Boolean deleteProduct(Long id) {

        Product productBdd = productRepository.findById(id).orElse(null);

        if ( productBdd == null )
            return false;

        productRepository.deleteById(id);
        return true;
    }
}
