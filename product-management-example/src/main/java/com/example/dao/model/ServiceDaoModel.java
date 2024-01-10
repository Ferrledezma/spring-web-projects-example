package com.example.dao.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.constant.ConstantExceptionMessage;
import com.example.entities.model.GeneralEntityModel;
import com.example.exception.DatabaseResourceNotFoundException;
import com.example.mapper.mappingAsDto.model.DTOMapperInterface;
import com.example.mapper.mappingAsEntity.model.EntityMapperInterface;
import com.example.mapper.updateMap.model.EntityUpdateMapperInterface;
import com.example.repository.model.RepositoryInterfaceModel;

public abstract class ServiceDaoModel<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate>
implements ServiceDaoInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	@Autowired
	protected RepositoryInterfaceModel<Entity> repository;
	@Autowired
	protected EntityMapperInterface<DTOPost, Entity> entityMapper;
	@Autowired
	protected DTOMapperInterface<Entity, DTOGet> dtoMapper;
	@Autowired
	protected EntityUpdateMapperInterface<DTOUpdate, Entity> updateMapper;

	@Override
	public DTOGet create(DTOPost dtoPost) {
		Entity entity = entityMapper.apply(dtoPost);
		repository.save(entity);
		return dtoMapper.apply(entity);
	}
	
	@Override
	public DTOGet update(Long id, DTOUpdate dtoUpdate) throws DatabaseResourceNotFoundException {
		Entity entity = find(id);
		updateMapper.accept(dtoUpdate, entity);
		repository.save(entity);
		return dtoMapper.apply(entity);
	}
	
	@Override
	public void delete(Long id) throws DatabaseResourceNotFoundException {
		if(repository.existsById(id))
			repository.deleteById(id);
		else
			throw new DatabaseResourceNotFoundException(String.format(ConstantExceptionMessage.RESOURCE_NOT_FOUND, "con el id " + id));
	}
	
	@Override
	public Entity find(Long id) throws DatabaseResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DatabaseResourceNotFoundException(String.format(ConstantExceptionMessage.RESOURCE_NOT_FOUND, "con el id " + id)));
	}
	
	@Override
	public List<DTOGet> findAll() {
		return repository.findAll()
				.stream()
				.map(dtoMapper)
				.toList();
	}
}
















