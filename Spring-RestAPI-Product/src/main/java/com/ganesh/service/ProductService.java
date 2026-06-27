package com.ganesh.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.dto.ProductDto;
import com.ganesh.entity.Product;

public interface ProductService{
	
	
	Product getProductById(Integer id);
	
	List<Product> getAllproducts();
	
	String saveProduct(ProductDto product);
	
	Product getProductByName(String name);
	
	List<Product> findbyCategory(String category);
	
	String deleteById(Integer id);
	
	String updateProductById(Integer id, Product product);

}
