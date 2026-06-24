package com.ganesh.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ganesh.entity.Product;
import com.ganesh.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{

	
	
	public List<Product> getProducts() {
		
		Product p1=new Product(1, "Laptop", 70000.00, 22, "Electronics");
		Product p2=new Product(2, "Mobile", 7000.00, 22, "Electronics");
		Product p3=new Product(3, "Tshirt", 80000.00, 22, "Clothes");
		Product p4=new Product(4, "Pen", 70000.00, 22, "Stationary");
		Product p5=new Product(5, "Suger", 700.00, 22, "Grocery");
		
		List<Product> list = Arrays.asList(p1,p2,p3,p4,p5);
		
		return list;
	}
	
	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		 List<Product> allProducts = getProducts();
		 
		 for (Product product : allProducts) {
			 
			if (product.getId() == id) {
				
				return product;
			}
		}
		 throw new ProductNotFoundException("Product not found for id = "+id);
	}

	@Override
	public List<Product> getAllproducts() {
		// TODO Auto-generated method stub
		return getProducts();
	}

	@Override
	public String saveProduct(Product product) {

		return "Product Saved Success";
	}

}
