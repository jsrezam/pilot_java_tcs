package com.tcsdemo.servicerest.service.impl;

import com.tcsdemo.servicerest.model.Product;
import com.tcsdemo.servicerest.repository.ProductRepository;
import com.tcsdemo.servicerest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product productBdd = productRepository.findById(id).orElse(null);

        if (productBdd == null )
            return null;

        productBdd.setName( product.getName() );
        productBdd.setDescription( product.getDescription() );
        productBdd.setSize( product.getSize() );

        return productRepository.save(productBdd);
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
