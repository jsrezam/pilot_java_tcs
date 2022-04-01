package com.tcsdemo.servicerest.service;

import com.tcsdemo.servicerest.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    Boolean deleteProduct(Long id);

}
