package com.tcsdemo.servicerest.controller;

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
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        try {
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id , @RequestBody Product product ){
        try {
            return new ResponseEntity<>(productService.updateProduct(id,product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
