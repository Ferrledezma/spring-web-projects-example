package com.example.entities.implement;

import java.util.ArrayList;
import java.util.List;

import com.example.constant.TableDataConstant;
import com.example.entities.model.GeneralEntityModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TableDataConstant.SUPPLIER_TABLE_NAME)
@NoArgsConstructor
@Getter
@Setter
public class SupplierEntity extends GeneralEntityModel {
	@Column(name = "nombre", nullable = false, unique = true, length = 100)
	private String name;
	
	@Column(name = "correo", nullable = false, unique = true, length = 50)
	private String email;
	
	@Column(name = "direccion", nullable = false, length = 200)
	private String address;
	
	@OneToMany(
			mappedBy = "supplier",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	@JsonBackReference
	private List<ProductEntity> productList = new ArrayList<>();

	public SupplierEntity(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
}
