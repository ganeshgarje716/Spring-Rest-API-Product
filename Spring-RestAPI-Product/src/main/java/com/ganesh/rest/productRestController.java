package com.ganesh.rest;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.dto.ProductDto;
import com.ganesh.entity.Product;
import com.ganesh.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class productRestController {

	
	@Autowired
	ProductService productService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody ProductDto productDto) {
		
		String save = productService.saveProduct(productDto);
		
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
	
	
	@GetMapping("/byname")
	public ResponseEntity<Product> getProductByName(@RequestParam String name) {
		
		Product product = productService.getProductByName(name);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/bycategory")
	public ResponseEntity<List<Product>> getProductByCategory(@RequestParam String category) {
		
		List<Product> product = productService.findbyCategory(category);
		
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		
		String msg = productService.deleteById(id);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Product product) {
		
		String update = productService.updateProductById(id, product);
		
		return new ResponseEntity<String>(update,HttpStatus.OK);
	}
	
 
	
	
	
	
	
	
	

	
}
