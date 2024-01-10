package com.example.repository.implement;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.constant.SqlQueryConstant;
import com.example.entities.implement.ProductEntity;
import com.example.repository.model.RepositoryInterfaceModel;

public interface ProductRepository extends RepositoryInterfaceModel<ProductEntity> {
	@Query(value = SqlQueryConstant.FIND_PRODUCT_BY_VALUE, nativeQuery = true)
	public List<ProductEntity> findAllThatMatch( String columnValue);
}
