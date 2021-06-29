package com.group.asd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Person Entity
 * @author ingalexandrasarmiento
 */
@Data
@Entity
@Table(name = "PERSONAS")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private Integer idPerson;
	
	@Column(name = "NOMBRE")
	private String name;
	

}
