package com.ganesh.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.entity.Product;

public interface ProductService{
	
	
	Product getProductById(Integer id);
	
	List<Product> getAllproducts();
	
	String saveProduct(Product product);

}
