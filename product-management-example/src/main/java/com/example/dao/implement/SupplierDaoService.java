package com.example.dao.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.model.ServiceDaoModel;
import com.example.dto.suplier.implement.request.SupplierDTOPost;
import com.example.dto.suplier.implement.request.SupplierDTOUpdate;
import com.example.dto.suplier.implement.response.SupplierDTOGet;
import com.example.entities.implement.SupplierEntity;
import com.example.repository.implement.SupplierRepository;

@Service
public class SupplierDaoService extends ServiceDaoModel<SupplierEntity, SupplierDTOPost, SupplierDTOGet, SupplierDTOUpdate> {
	@Autowired
	private SupplierRepository supplierRepository;
	@Override
	public List<SupplierDTOGet> findAllThatMatch(String value) {
		return supplierRepository.findAllThatMatch(value)
				.stream()
				.map(dtoMapper)
				.toList();
	}

}
