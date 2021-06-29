package com.group.asd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to return the city information
 * 
 * @author ingalexandrasarmiento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
	
	private Integer idCity;
	private String name;

}
