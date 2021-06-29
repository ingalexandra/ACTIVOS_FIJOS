package com.group.asd.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class SwaggerConstants {

	/**
	 * Contains the API package
	 * 
	 * @author ingalexandrasarmiento
	 */
	public static final String PACKAGE = "com.group.asd.controller";

	/**
	 * Contains the API response message OK
	 * 
	 * @author ingalexandrasarmiento
	 */
	public static final String RESPONSE_MESSAGE_200 = "Successfull request";

	/**
	 * Contains the API response not found
	 * 
	 * @author ingalexandrasarmiento
	 */
	public static final String RESPONSE_MESSAGE_404 = "Not found";
	
	/**
	 * Contains the API response bad request
	 * 
	 * @author ingalexandrasarmiento
	 */
	public static final String RESPONSE_MESSAGE_400 = "Bad request";


	/**
	 * Contains the API response internal server error
	 * 
	 * @author ingalexandrasarmiento
	 */
	public static final String RESPONSE_MESSAGE_500 = "Internal server error";
	
}
