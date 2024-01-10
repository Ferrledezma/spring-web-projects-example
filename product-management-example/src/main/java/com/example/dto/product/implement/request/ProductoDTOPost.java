package com.example.dto.product.implement.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@Getter
public class ProductoDTOPost{
	@NotBlank
	private String name;
	@NotBlank
	private String type;
	@NotBlank
	private String brand;
	@NotNull @PositiveOrZero
	private Double pricePerUnit;
	@NotNull @PositiveOrZero
	private Integer stock;
	@NotNull
	private String supplierName;
}
