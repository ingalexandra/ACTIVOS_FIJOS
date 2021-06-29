package com.group.asd.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to return the response of the services at a general level
 * 
 * @author ingalexandrasarmiento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {

	private T data;
	private String code;
	private String description;
	@JsonIgnore
	private HttpStatus status;

	public ResponseDTO(T data, String code, String description) {
		this.data = data;
		this.code = code;
		this.description = description;
	}
}
