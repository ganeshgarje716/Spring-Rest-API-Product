package com.ganesh.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	
	
	@NotNull(message = "Id Is Required")
	private Integer id;
	
	@NotBlank(message = "Id Is Required")
	private String name;
	
	@NotNull(message = "Id Is Required")
	private Double price;
	
	@NotNull(message = "Id Is Required")
	private Integer qty;
	
	@NotBlank(message = "Id Is Required")
	private String category;
	

}
