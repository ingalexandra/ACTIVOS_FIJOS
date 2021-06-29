package com.group.asd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.asd.dto.ResponseDTO;
import com.group.asd.dto.TypeAssetDTO;
import com.group.asd.endpoint.TypeAssetEndpoint;
import com.group.asd.service.ITypeAssetService;
import com.group.asd.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(TypeAssetEndpoint.TYPE_ASSET_V1_0)
@CrossOrigin(origins = "*")
public class TypeAssetController {
	
	@Autowired
	private ITypeAssetService typeAssetService;
	
	/**
	 * List all types of fixed assets
	 * 
	 * @author ingalexandrasarmiento
	 * @return ResponseEntity<ResponseDTO<List<TypeAssetDTO>>>
	 */
	@GetMapping(value = TypeAssetEndpoint.FIND_ALL, produces = "application/json")
	@ApiOperation(value = "List all types of fixed assets", notes = "List all types of fixed assets that are registered in the database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerConstants.RESPONSE_MESSAGE_200),
			@ApiResponse(code = 404, message = SwaggerConstants.RESPONSE_MESSAGE_404),
			@ApiResponse(code = 500, message = SwaggerConstants.RESPONSE_MESSAGE_500)})
	public ResponseEntity<ResponseDTO<List<TypeAssetDTO>>> findAll() {
		ResponseDTO<List<TypeAssetDTO>> resp = typeAssetService.findAll();
		return ResponseEntity.status(resp.getStatus()).body(resp);
	}

}
