package com.ganesh.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

	
	
	@NotBlank(message = "Id Is Required")
	private String name;
	
	@NotNull(message = "Id Is Required")
	private Double price;
	
	@NotNull(message = "Id Is Required")
	private Integer qty;
	
	@NotBlank(message = "Id Is Required")
	private String category;
	
	@NotNull(message = "MFG Date Is Required")
    private LocalDate mfgDate;
	
	@NotNull(message = "EXP Date Is Required")
	private LocalDate expDate;
	
	
}
