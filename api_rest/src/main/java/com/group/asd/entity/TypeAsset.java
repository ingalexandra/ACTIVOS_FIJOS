package com.group.asd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TIPOS_ACTIVOS")
public class TypeAsset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_ACTIVO_FIJO")
	private Integer idTypeAsset;
	
	@Column(name = "NOMBRE")
	private String name;
	
}
