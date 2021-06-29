package com.group.asd.service;

import java.util.List;

import com.group.asd.dto.ResponseDTO;
import com.group.asd.dto.TypeAssetDTO;

public interface ITypeAssetService {

	ResponseDTO<List<TypeAssetDTO>> findAll();
	
}
