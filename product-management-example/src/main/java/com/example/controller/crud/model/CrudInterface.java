package com.example.controller.crud.model;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.constant.TableDataConstant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface CrudInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	public ResponseEntity<DTOGet> create(@RequestBody DTOPost dtoPost, HttpServletRequest request);

	public ResponseEntity<DTOGet> update(
			@NotNull @Positive @PathVariable(TableDataConstant.ID_COLUMN_NAME) Long id,
			@Valid @RequestBody DTOUpdate dtoUpdate
			);

	public ResponseEntity<?> delete(@NotNull @Positive @PathVariable(TableDataConstant.ID_COLUMN_NAME) Long id);
	
	public ResponseEntity<List<DTOGet>> findAll();
	
	public ResponseEntity<List<DTOGet>> findMatch(@NotBlank String value);

}
