package com.group.asd.endpoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Endpoints of Fixed Asset Controller
 * 
 * @author ingalexandrasarmiento
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FixedAssetEndpoint {

	public static final String ASSET_V1_0 = "/api/fixedAsset";
	public static final String FIND_BY_ID = "/{id}";
	public static final String SEARCH_FIXED_ASSETS = "/searchByFilter";
	public static final String SAVE_FIXED_ASSETS = "/save";
	
}
