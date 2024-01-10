package com.example.dto.product.implement.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class ProductDTOGet {
	@NotNull @Positive
	private Long id;
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
	private Double totalCost;
	@NotBlank
	private String supplierName;
	
}











