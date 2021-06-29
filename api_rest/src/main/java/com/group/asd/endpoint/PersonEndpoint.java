package com.group.asd.endpoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Endpoints of Person Controller
 * 
 * @author ingalexandrasarmiento
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonEndpoint {
	
	public static final String PERSON_V1_0 = "/api/person";
	public static final String FIND_ALL = "/findAll";

}
