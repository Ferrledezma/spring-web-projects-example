package com.example.mapper.mappingAsEntity.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.constant.ConstantExceptionMessage;
import com.example.constant.ProductTypeConstant;
import com.example.dto.product.implement.request.ProductoDTOPost;
import com.example.entities.implement.ProductEntity;
import com.example.entities.implement.SupplierEntity;
import com.example.exception.DatabaseResourceNotFoundException;
import com.example.exception.InvalidDataTypeException;
import com.example.mapper.mappingAsEntity.model.EntityMapperInterface;
import com.example.repository.implement.SupplierRepository;

@Service
public class ProductMapperImp implements EntityMapperInterface<ProductoDTOPost, ProductEntity> {
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public ProductEntity apply(ProductoDTOPost productDto) throws InvalidDataTypeException, DatabaseResourceNotFoundException {
		Optional<ProductTypeConstant> productTypeOptional = Optional.ofNullable(
				Optional.of(ProductTypeConstant.valueOf(productDto.getType()))
				).orElseThrow(() -> new InvalidDataTypeException(
						String.format(ConstantExceptionMessage.INVALID_DATA_TYPE, productDto.getType(), "tipo de producto"))
						);
		
		SupplierEntity supplier = supplierRepository.findByName(productDto.getSupplierName())
				.orElseThrow(() -> new DatabaseResourceNotFoundException(
						String.format(ConstantExceptionMessage.RESOURCE_NOT_FOUND, "con el nombre " + productDto.getSupplierName()))
						);
		
		return ProductEntity.builder()
				.name(productDto.getName())
				.pruductType(productTypeOptional.get())
				.brand(productDto.getBrand())
				.pricePerUnit(productDto.getPricePerUnit())
				.stock(productDto.getStock())
				.supplier(supplier)
				.build();
	}

}
