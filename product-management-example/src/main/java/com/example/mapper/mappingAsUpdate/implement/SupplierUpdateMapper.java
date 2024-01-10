package com.example.mapper.mappingAsUpdate.implement;

import org.springframework.stereotype.Service;

import com.example.dto.suplier.implement.request.SupplierDTOUpdate;
import com.example.entities.implement.SupplierEntity;
import com.example.mapper.updateMap.model.EntityUpdateMapperInterface;

@Service
public class SupplierUpdateMapper implements EntityUpdateMapperInterface<SupplierDTOUpdate, SupplierEntity> {

	@Override
	public void accept(SupplierDTOUpdate supplierDto, SupplierEntity supplier) {
		if (supplierDto.getName() != null && !supplierDto.getName().isBlank()
				&& !supplier.getName().equalsIgnoreCase(supplierDto.getName())) {
			supplier.setName(supplierDto.getName());
		}
		if (supplierDto.getEmail() != null && !supplierDto.getEmail().isBlank()
				&& !supplier.getEmail().equalsIgnoreCase(supplierDto.getEmail())) {
			supplier.setEmail(supplierDto.getEmail());
		}
		if (supplierDto.getAddress() != null && !supplierDto.getAddress().isBlank()
				&& !supplier.getAddress().equalsIgnoreCase(supplierDto.getAddress())) {
			supplier.setAddress(supplierDto.getAddress());
		}
	}

}
