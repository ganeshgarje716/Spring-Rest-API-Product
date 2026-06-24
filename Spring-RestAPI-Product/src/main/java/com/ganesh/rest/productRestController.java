package com.ganesh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.entity.Product;
import com.ganesh.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class productRestController {

	
	@Autowired
	ProductService productService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Product product) {
		
		String save = productService.saveProduct(product);
		System.err.println(product);
		
		return new ResponseEntity<String>(save,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		
		 Product product = productService.getProductById(id);
		 		 
		 if (product==null) {
			
			 return new ResponseEntity<Product>(product,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		
		 List<Product> list = productService.getAllproducts();
		 
		 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
//	@GetMapping("/product/{id}")
//	public Product getProductById(@PathVariable Integer id) {
//		
//		return productService.getProductById(id);
//	}
//	
//	
//	
//	@GetMapping("/products")
//	public List<Product> getAllProducts() {
//		
//		return productService.getAllproducts();
//	}
	
}
