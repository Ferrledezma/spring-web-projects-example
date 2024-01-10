package com.example.dao.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.model.ServiceDaoModel;
import com.example.dto.product.implement.request.ProductDTOUpdate;
import com.example.dto.product.implement.request.ProductoDTOPost;
import com.example.dto.product.implement.response.ProductDTOGet;
import com.example.entities.implement.ProductEntity;
import com.example.repository.implement.ProductRepository;

@Service
public class ProductDaoService extends ServiceDaoModel<ProductEntity, ProductoDTOPost, ProductDTOGet, ProductDTOUpdate> {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTOGet> findAllThatMatch(String value) {
		return productRepository.findAllThatMatch(value)
				.stream()
				.map(dtoMapper)
				.toList();
	}
	
}
