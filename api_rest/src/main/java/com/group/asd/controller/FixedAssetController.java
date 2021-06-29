package com.group.asd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.asd.dto.FilterDTO;
import com.group.asd.dto.FixedAssetDTO;
import com.group.asd.dto.ResponseDTO;
import com.group.asd.endpoint.FixedAssetEndpoint;
import com.group.asd.service.IFixedAssetService;
import com.group.asd.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(FixedAssetEndpoint.ASSET_V1_0)
@CrossOrigin(origins = "*")
public class FixedAssetController {
	
	@Autowired
	private IFixedAssetService fixedAssetService;
	
	/**
	 * Search the fixed asset by ID
	 * 
	 * @author ingalexandrasarmiento
	 * @param id ID of fixed asset
	 * @return ResponseEntity<ResponseDTO<FixedAssetDTO>>
	 */
	@GetMapping(value = FixedAssetEndpoint.FIND_BY_ID, produces = "application/json")
	@ApiOperation(value = "Search the fixed asset by ID", notes = "List the information of a fixed asset according to the ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerConstants.RESPONSE_MESSAGE_200),
			@ApiResponse(code = 404, message = SwaggerConstants.RESPONSE_MESSAGE_404),
			@ApiResponse(code = 500, message = SwaggerConstants.RESPONSE_MESSAGE_500)})
	public ResponseEntity<ResponseDTO<FixedAssetDTO>> findById(@PathVariable("id") Integer id) {
		ResponseDTO<FixedAssetDTO> resp = fixedAssetService.findById(id);
		return ResponseEntity.status(resp.getStatus()).body(resp);
	}
	
	/**
	 * Filter fixed assets
	 * 
	 * @author ingalexandrasarmiento
	 * @param filter Filter by type, serial and / or purchase date
	 * @return ResponseEntity<ResponseDTO<List<FixedAssetDTO>>>
	 */
	@PostMapping(value = FixedAssetEndpoint.SEARCH_FIXED_ASSETS, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Filter fixed assets", notes = "Filter fixed assets by type, serial and / or purchase date")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerConstants.RESPONSE_MESSAGE_200),
			@ApiResponse(code = 404, message = SwaggerConstants.RESPONSE_MESSAGE_404),
			@ApiResponse(code = 500, message = SwaggerConstants.RESPONSE_MESSAGE_500)})
	public ResponseEntity<ResponseDTO<List<FixedAssetDTO>>> searchByFilter(@RequestBody FilterDTO filter) {
		ResponseDTO<List<FixedAssetDTO>> resp = fixedAssetService.searchByFilter(filter);
		return ResponseEntity.status(resp.getStatus()).body(resp);
	}
	
	/**
	 * Save or update a fixed asset
	 * 
	 * @author ingalexandrasarmiento
	 * @param fixedAssetDTO Fixed asset to save or update
	 * @return ResponseEntity<ResponseDTO<FixedAssetDTO>>
	 */
	@PostMapping(value = FixedAssetEndpoint.SAVE_FIXED_ASSETS, consumes = "application/json")
	@ApiOperation(value = "Save or update a fixed asset", notes = "Save or update the information of a fixed asset")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerConstants.RESPONSE_MESSAGE_200),
			@ApiResponse(code = 400, message = SwaggerConstants.RESPONSE_MESSAGE_400),
			@ApiResponse(code = 500, message = SwaggerConstants.RESPONSE_MESSAGE_500)})
	public ResponseEntity<ResponseDTO<FixedAssetDTO>> save(@RequestBody FixedAssetDTO fixedAssetDTO) {
		ResponseDTO<FixedAssetDTO> resp = fixedAssetService.saveFixedAsset(fixedAssetDTO);
		return ResponseEntity.status(resp.getStatus()).body(resp);
	}

}
