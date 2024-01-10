package com.example.mapper.mappingAsDto.implement;

import org.springframework.stereotype.Service;

import com.example.dto.suplier.implement.response.SupplierDTOGet;
import com.example.entities.implement.SupplierEntity;
import com.example.mapper.mappingAsDto.model.DTOMapperInterface;

@Service
public class SupplierDTOMapper implements DTOMapperInterface<SupplierEntity, SupplierDTOGet> {

	@Override
	public SupplierDTOGet apply(SupplierEntity supplier) {
		return new SupplierDTOGet(supplier.getId(), supplier.getName(), supplier.getEmail(), supplier.getAddress());
	}
}
