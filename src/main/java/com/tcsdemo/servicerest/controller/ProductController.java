package com.tcsdemo.servicerest.controller;

import com.tcsdemo.servicerest.dto.ProductDto;
import com.tcsdemo.servicerest.exception.ProductException;
import com.tcsdemo.servicerest.model.Product;
import com.tcsdemo.servicerest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        try {
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        try {
            return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id , @RequestBody ProductDto productDto ){
        try {
            return new ResponseEntity<>(productService.updateProduct(id,productDto), HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value="{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){

        Boolean response = productService.deleteProduct(id);

        if (!response)
            return new ResponseEntity<>("The product is does not exist", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
