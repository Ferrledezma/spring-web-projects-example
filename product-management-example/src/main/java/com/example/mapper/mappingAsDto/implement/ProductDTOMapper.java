package com.example.mapper.mappingAsDto.implement;

import org.springframework.stereotype.Service;

import com.example.dto.product.implement.response.ProductDTOGet;
import com.example.entities.implement.ProductEntity;
import com.example.mapper.mappingAsDto.model.DTOMapperInterface;

@Service
public class ProductDTOMapper implements DTOMapperInterface<ProductEntity, ProductDTOGet> {
	
	@Override
	public ProductDTOGet apply(ProductEntity product) {
		// TODO Auto-generated method stub
		return ProductDTOGet.builder()
				.id(product.getId())
				.name(product.getName())
				.type(product.getType().toString())
				.brand(product.getBrand())
				.pricePerUnit(product.getPricePerUnit())
				.stock(product.getStock())
				.totalCost(product.getTotalCost())
				.supplierName(product.getSupplier().getName())
				.build();
	}

}
