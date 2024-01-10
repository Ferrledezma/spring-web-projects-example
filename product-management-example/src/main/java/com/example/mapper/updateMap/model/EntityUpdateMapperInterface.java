package com.example.mapper.updateMap.model;

import java.util.function.BiConsumer;

import com.example.entities.model.GeneralEntityModel;

public interface EntityUpdateMapperInterface<DTOUpdate, Entity extends GeneralEntityModel> extends BiConsumer<DTOUpdate, Entity> {

}
