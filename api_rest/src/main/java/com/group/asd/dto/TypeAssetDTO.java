package com.group.asd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to return the types of fixed asset information
 * 
 * @author ingalexandrasarmiento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeAssetDTO {

	private Integer idTypeAsset;
	private String name;
	
}
