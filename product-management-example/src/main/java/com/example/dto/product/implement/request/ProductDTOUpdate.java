package com.example.dto.product.implement.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@Getter
public class ProductDTOUpdate {
	private String name;
	private String brand;
	@PositiveOrZero
	private Double pricePerUnit;
	@PositiveOrZero
	private Integer stock;
}
