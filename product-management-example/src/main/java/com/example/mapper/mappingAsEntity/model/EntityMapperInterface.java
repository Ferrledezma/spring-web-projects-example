package com.example.mapper.mappingAsEntity.model;

import java.util.function.Function;

import com.example.entities.model.GeneralEntityModel;

public interface EntityMapperInterface<DTOPost, Entity extends GeneralEntityModel> extends Function<DTOPost, Entity> {

}
