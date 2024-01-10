package com.example.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.model.GeneralEntityModel;

public interface RepositoryInterfaceModel<Entity extends GeneralEntityModel> extends JpaRepository<Entity, Long> {

}
