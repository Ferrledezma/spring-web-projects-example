package com.example.mapper.mappingAsDto.model;

import java.util.function.Function;

import com.example.entities.model.GeneralEntityModel;

public interface DTOMapperInterface<Entity extends GeneralEntityModel, DTOGet> extends Function<Entity, DTOGet> {

}
