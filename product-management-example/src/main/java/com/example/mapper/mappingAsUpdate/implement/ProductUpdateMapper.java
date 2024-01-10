package com.example.mapper.mappingAsUpdate.implement;

import org.springframework.stereotype.Service;

import com.example.dto.product.implement.request.ProductDTOUpdate;
import com.example.entities.implement.ProductEntity;
import com.example.mapper.updateMap.model.EntityUpdateMapperInterface;

@Service
public class ProductUpdateMapper implements EntityUpdateMapperInterface<ProductDTOUpdate, ProductEntity> {

	@Override
	public void accept(ProductDTOUpdate productDto, ProductEntity product) {
		if (productDto.getName() != null && !productDto.getName().isBlank()
				&& !product.getName().equalsIgnoreCase(productDto.getName())) {
			product.setName(productDto.getName());
		}
		if (productDto.getBrand() != null && !productDto.getBrand().isBlank()
				&& !product.getBrand().equalsIgnoreCase(productDto.getBrand())) {
			product.setBrand(productDto.getBrand());
		}
		if (productDto.getPricePerUnit() != null && product.getPricePerUnit() != productDto.getPricePerUnit()) {
			product.setPricePerUnit(productDto.getPricePerUnit());
		}
		if (productDto.getStock() != null && product.getStock() != productDto.getStock()) {
			product.setStock(productDto.getStock());
		}
	}
}
