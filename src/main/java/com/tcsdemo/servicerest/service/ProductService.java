package com.tcsdemo.servicerest.service;

import com.tcsdemo.servicerest.dto.ProductDto;
import com.tcsdemo.servicerest.exception.ProductException;
import com.tcsdemo.servicerest.model.Product;
import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts();
    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto) throws ProductException;
    Boolean deleteProduct(Long id);

}
