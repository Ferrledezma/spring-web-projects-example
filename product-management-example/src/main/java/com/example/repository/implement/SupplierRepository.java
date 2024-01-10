package com.example.repository.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.constant.SqlQueryConstant;
import com.example.entities.implement.SupplierEntity;
import com.example.repository.model.RepositoryInterfaceModel;

public interface SupplierRepository extends RepositoryInterfaceModel<SupplierEntity> {
	@Query(value = SqlQueryConstant.FIND_SUPLIER_BY_VALUE, nativeQuery = true)
	public List<SupplierEntity> findAllThatMatch(String columnValue);
	
	@Query(value = SqlQueryConstant.FIND_BY_NAME, nativeQuery = true)
	public Optional<SupplierEntity> findByName(String name);
}
