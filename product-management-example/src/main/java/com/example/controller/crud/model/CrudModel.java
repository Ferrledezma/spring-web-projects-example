package com.example.controller.crud.model;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.constant.ConstantPath;
import com.example.constant.TableDataConstant;
import com.example.dao.model.ServiceDaoInterface;
import com.example.entities.model.GeneralEntityModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public abstract class CrudModel<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate>
implements CrudInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	@Autowired
	private ServiceDaoInterface<Entity, DTOPost, DTOGet, DTOUpdate> service;

	@Override
	@PostMapping(ConstantPath.CREATE)
	public ResponseEntity<DTOGet> create(@RequestBody DTOPost dtoPost, HttpServletRequest request){
		return ResponseEntity.created(URI.create(request.getRequestURI()))
				.body(service.create(dtoPost));
	}
	
	@PatchMapping(ConstantPath.UPDATE)
	public ResponseEntity<DTOGet> update(
			@NotNull @Positive @PathVariable(TableDataConstant.ID_COLUMN_NAME) Long id,
			@Valid @RequestBody DTOUpdate dtoUpdate
			){
		return ResponseEntity.ok(service.update(id, dtoUpdate));
	}
	
	@DeleteMapping(ConstantPath.DELETE)
	public ResponseEntity<?> delete(@NotNull @Positive @PathVariable(TableDataConstant.ID_COLUMN_NAME) Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(ConstantPath.FIND_ALL)
	public ResponseEntity<List<DTOGet>> findAll(){
		List<DTOGet> resourceList = service.findAll();
		
		if(resourceList.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(resourceList);
	}
	
	@Override
	@GetMapping(ConstantPath.FIND_THAT_MATCH)
	public ResponseEntity<List<DTOGet>> findMatch(@NotBlank String value){
		List<DTOGet> resourceList = service.findAllThatMatch(value);
		if(resourceList.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(resourceList);
	}
}















