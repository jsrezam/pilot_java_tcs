package com.tcsdemo.servicerest;

import com.tcsdemo.servicerest.model.Product;
import com.tcsdemo.servicerest.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServicerestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicerestApplication.class, args);
	}

	@Bean
	CommandLineRunner run (ProductRepository productRepository){
		return args -> {
			productRepository.save(new Product(null,"Lenovo","100.00",1L));
			productRepository.save(new Product(null,"Dell Latitude","92.00",2L));
			productRepository.save(new Product(null,"HP Pavilion","150.00",3L));
			productRepository.save(new Product(null,"Dell Precision","500.90",4L));
			productRepository.save(new Product(null,"Dell Inspiron","110.40",5L));
			productRepository.save(new Product(null,"MacBook Pro","1000.99",6L));
			productRepository.save(new Product(null,"iMac","600.00",7L));
			productRepository.findAll().forEach(product -> System.out.println(product.getName()));
		};
	}


}
