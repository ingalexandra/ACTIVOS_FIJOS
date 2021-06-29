package com.group.asd.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "ACTIVOS_FIJOS")
public class FixedAsset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACTIVO_FIJO")
	private Integer idFixedAsset;
	
	@Column(name = "FK_TIPO")
	private Integer idType;
	
	@Column(name = "FK_AREA")
	private Integer idArea;
	
	@Column(name = "FK_PERSONA")
	private Integer idPerson;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "DESCRIPCION")
	private String description;
	
	@Column(name = "SERIAL")
	private String serialNumber;
	
	@Column(name = "NUMERO_INVENTARIO")
	private Integer inventoryNumber;
	
	@Column(name = "PESO")
	private Float assetWeight;
	
	@Column(name = "ALTO")
	private Float assetHeigh;
	
	@Column(name = "ANCHO")
	private Float assetWidth;
	
	@Column(name = "LARGO")
	private Float assetLong;
	
	@Column(name = "VALOR_COMPRA")
	private BigInteger purchaseValue;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_COMPRA")
	private Date purchaseDate;
	
	
}
