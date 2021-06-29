package com.group.asd.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to filter fixed assets
 * 
 * @author ingalexandrasarmiento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDTO {

	private String type;
	private Date purchaseDate;
	private String serialNumber;
	
}
