package com.group.asd.service;

import java.util.List;

import com.group.asd.dto.AreaDTO;
import com.group.asd.dto.ResponseDTO;

public interface IAreaService {
	
	ResponseDTO<List<AreaDTO>> findAll();
	
}
