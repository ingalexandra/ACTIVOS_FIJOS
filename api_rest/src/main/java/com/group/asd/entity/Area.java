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
@Table(name = "AREAS")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AREA")
	private Integer idArea;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "FK_CIUDAD")
	private Integer idCity;
	
}
