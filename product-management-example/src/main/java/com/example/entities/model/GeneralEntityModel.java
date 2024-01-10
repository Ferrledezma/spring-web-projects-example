package com.example.entities.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class GeneralEntityModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
