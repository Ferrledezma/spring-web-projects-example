package com.example.dto.suplier.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class SupplierDTOGetModel {
	@NotNull @Positive
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String address;
}
