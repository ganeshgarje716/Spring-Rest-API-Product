package com.ganesh.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

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
