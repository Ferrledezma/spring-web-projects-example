package com.example.entities.implement;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.constant.TableDataConstant;
import com.example.entities.model.GeneralEntityModel;
import com.example.constant.ProductTypeConstant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TableDataConstant.PRODUCT_TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"creationDate", "updateDate"})
public class ProductEntity extends GeneralEntityModel {
	@Column(name = "nombre", nullable = false, length = 50)
	@Setter
	private String name;
	
	@Column(name = "tipo", nullable = false, updatable = false, length = 40)
	@Enumerated(EnumType.STRING)
	private ProductTypeConstant type;
	
	@Column(name = "marca", nullable = false, length = 100)
	@Setter
	private String brand;
	
	@Column(name = "precio_unidad", nullable = false)
	private Double pricePerUnit;
	
	@Column(name = "cantidad", nullable = false)
	private Integer stock;
	
	@ManyToOne(optional = false)
	@JsonManagedReference
	@JoinColumn(name = TableDataConstant.SUPPLIER_ID_COLUMN, nullable = false, updatable = false)
	private SupplierEntity supplier;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private Date creationDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = false)
	private Date updateDate;
	
	@Transient
	private Double totalCost;

	private ProductEntity(
			String name, ProductTypeConstant type, String brand,
			Double pricePerUnit, Integer stock, SupplierEntity supplier
			) {
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.pricePerUnit = pricePerUnit;
		this.stock = stock;
		this.supplier = supplier;
	}

	@PostLoad
	public void totalCost() {
		this.totalCost = pricePerUnit * stock;
	}
	
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
		totalCost();
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
		totalCost();
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String name;
		private ProductTypeConstant type;
		private String brand;
		private Double pricePerUnit;
		private Integer stock;
		private SupplierEntity supplier;
	
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder pruductType(ProductTypeConstant type) {
			this.type = type;
			return this;
		}
		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}
		public Builder pricePerUnit(Double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
			return this;
		}
		public Builder stock(Integer stock) {
			this.stock = stock;
			return this;
		}
		public Builder supplier(SupplierEntity supplier) {
			this.supplier = supplier;
			return this;
		}
	
		public ProductEntity build() {
			return new ProductEntity(
					name,
					type,
					brand,
					pricePerUnit,
					stock,
					supplier);
		}
	}
}


















