package com.tcsdemo.servicerest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcsdemo.servicerest.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
public class ProductDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long size;

    @JsonIgnore
    public Product getAsEntity(){
        return new Product(this.id, this.name, this.description, this.size);
    }

}
