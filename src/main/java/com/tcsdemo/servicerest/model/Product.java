package com.tcsdemo.servicerest.model;

import com.tcsdemo.servicerest.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long size;

    public ProductDto getAsDto(){
       return new ProductDto(this.id, this.name, this.description, this.size);
    }

}
