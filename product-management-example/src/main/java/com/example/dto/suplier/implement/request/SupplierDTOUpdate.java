package com.example.dto.suplier.implement.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SupplierDTOUpdate {
	private String name;
	private String email;
	private String address;
}
