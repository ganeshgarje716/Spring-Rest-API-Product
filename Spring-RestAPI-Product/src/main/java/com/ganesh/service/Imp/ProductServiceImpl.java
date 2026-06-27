package com.ganesh.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.dto.ProductDto;
import com.ganesh.entity.Product;
import com.ganesh.exception.ProductNotFoundException;
import com.ganesh.repository.ProductRepository;
import com.ganesh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepository;
	
	
	
	
	@Override
	public Product getProductById(Integer id) {
		 
		Optional<Product> byId = productRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Product product = byId.get();
			
			return product;
		}
		 throw new ProductNotFoundException("Product not found for id = "+id);
	}

	@Override
	public List<Product> getAllproducts() {

		List<Product> all = productRepository.findAll();
		
		return all;
	}

	@Override
	public String saveProduct(ProductDto productDto) {
		
		Product entity=new Product();
		
		entity.setName(productDto.getName());
		entity.setPrice(productDto.getPrice());
		entity.setQty(productDto.getQty());
		entity.setCategory(productDto.getCategory());
		entity.setMfgDate(productDto.getMfgDate());
		entity.setExpDate(productDto.getExpDate());
		
		productRepository.save(entity);

		return "Product Saved Success";
	}

	@Override
	public Product getProductByName(String name) {
		
		Product product = productRepository.findByName(name);
		
		if (product!=null) {
			
			return product;
		}
		
		throw new ProductNotFoundException("Product Not Found For Name = "+name);
	}

	
	@Override
	public List<Product> findbyCategory(String category) {
		
		List<Product> product = productRepository.findByCategory(category);
		
		if (!product.isEmpty()) {
			
			return product;
		}
		
		throw new ProductNotFoundException("Product Not Found For Category = "+category);
	}

	
	@Override
	public String deleteById(Integer id) {
		
		if (productRepository.existsById(id)) {
			
			productRepository.deleteById(id);
			
			return "Deleted Success";
		}

		throw new ProductNotFoundException("Product Not Found For Id = "+id);
	}

	@Override
	public String updateProductById(Integer id, Product product) {

		Optional<Product> byId = productRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Product existing = byId.get();
			
			existing.setName(product.getName());
			existing.setPrice(product.getPrice());
			existing.setQty(product.getQty());
			existing.setCategory(product.getCategory());
			existing.setMfgDate(product.getMfgDate());
			existing.setExpDate(product.getExpDate());
			
			productRepository.save(existing);
			
			return "Product Update Success";
		}
		
		throw new ProductNotFoundException("Product Not Found For Id = "+id);
	}

}
