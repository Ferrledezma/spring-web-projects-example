package com.example.dto.suplier.implement.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SupplierDTOPost {
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String address;
}
