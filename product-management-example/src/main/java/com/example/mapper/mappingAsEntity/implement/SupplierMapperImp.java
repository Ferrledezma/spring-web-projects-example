package com.example.mapper.mappingAsEntity.implement;

import org.springframework.stereotype.Service;

import com.example.dto.suplier.implement.request.SupplierDTOPost;
import com.example.entities.implement.SupplierEntity;
import com.example.mapper.mappingAsEntity.model.EntityMapperInterface;

@Service
public class SupplierMapperImp implements EntityMapperInterface<SupplierDTOPost, SupplierEntity> {

	@Override
	public SupplierEntity apply(SupplierDTOPost supplierDto) {
		return new SupplierEntity(supplierDto.getName(), supplierDto.getEmail(), supplierDto.getAddress());
	}

}
