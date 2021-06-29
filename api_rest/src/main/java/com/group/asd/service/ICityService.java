package com.group.asd.service;

import java.util.List;

import com.group.asd.dto.CityDTO;
import com.group.asd.dto.ResponseDTO;

public interface ICityService {
	
	ResponseDTO<List<CityDTO>> findAll();

}
