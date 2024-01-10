package com.example.dao.model;

import java.util.List;

import com.example.entities.model.GeneralEntityModel;
import com.example.exception.DatabaseResourceNotFoundException;

public interface ServiceDaoInterface<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate> {
	public DTOGet create(DTOPost dtoPost);
	
	public DTOGet update(Long id, DTOUpdate dtoUpdate) throws DatabaseResourceNotFoundException;
	
	public void delete(Long id) throws DatabaseResourceNotFoundException;
	
	public Entity find(Long id) throws DatabaseResourceNotFoundException;
	
	public List<DTOGet> findAll();
	
	public List<DTOGet> findAllThatMatch(String value);
}
