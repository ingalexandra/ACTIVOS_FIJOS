package com.group.asd.dto;

import java.math.BigInteger;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to return the information of the fixed assets
 * 
 * @author ingalexandrasarmiento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedAssetDTO {
	
	private Integer idFixedAsset;
	private Integer idType;
	private Integer idArea;
	private Integer idPerson;
	private String name;
	private String description;
	private String serialNumber;
	private Integer inventoryNumber;
	private Float assetWeight;
	private Float assetHeigh;
	private Float assetWidth;
	private Float assetLong;
	private BigInteger purchaseValue;
	private Date purchaseDate;

	
}
