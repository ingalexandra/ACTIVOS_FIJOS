package com.group.asd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.asd.dto.AreaDTO;
import com.group.asd.dto.ResponseDTO;
import com.group.asd.endpoint.AreaEndpoint;
import com.group.asd.service.IAreaService;
import com.group.asd.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(AreaEndpoint.AREA_V1_0)
@CrossOrigin(origins = "*")
public class AreaController {
	
	@Autowired
	private IAreaService areaService;
	
	/**
	 * List all areas
	 * 
	 * @author ingalexandrasarmiento
	 * @return ResponseEntity<ResponseDTO<List<AreaDTO>>>
	 */
	@GetMapping(value = AreaEndpoint.FIND_ALL, produces = "application/json")
	@ApiOperation(value = "List all areas", notes = "List all the areas that are registered in the database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerConstants.RESPONSE_MESSAGE_200),
			@ApiResponse(code = 404, message = SwaggerConstants.RESPONSE_MESSAGE_404),
			@ApiResponse(code = 500, message = SwaggerConstants.RESPONSE_MESSAGE_500)})
	public ResponseEntity<ResponseDTO<List<AreaDTO>>> findAll() {
		ResponseDTO<List<AreaDTO>> resp = areaService.findAll();
		return ResponseEntity.status(resp.getStatus()).body(resp);
	}

}
