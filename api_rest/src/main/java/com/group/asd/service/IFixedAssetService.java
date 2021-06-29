package com.group.asd.service;

import com.group.asd.dto.FixedAssetDTO;

import java.util.List;

import com.group.asd.dto.FilterDTO;
import com.group.asd.dto.ResponseDTO;

public interface IFixedAssetService {

	ResponseDTO<FixedAssetDTO> findById(Integer id);
	ResponseDTO<List<FixedAssetDTO>> searchByFilter(FilterDTO filter);
	ResponseDTO<FixedAssetDTO> saveFixedAsset(FixedAssetDTO filter);

}
