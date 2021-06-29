package com.group.asd.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.asd.dto.ResponseDTO;
import com.group.asd.dto.TypeAssetDTO;
import com.group.asd.entity.TypeAsset;
import com.group.asd.mapper.TypeAssetMapper;
import com.group.asd.repository.TypeAssetRepository;
import com.group.asd.service.ITypeAssetService;
import com.group.asd.util.ApiResponseCode;

@Service
public class TypeAssetServiceImpl implements ITypeAssetService {
	
	@Autowired
	private TypeAssetMapper typeAssetMapper;
	@Autowired
	private TypeAssetRepository typeAssetRepository;
	
	/**
	 * Returns all types of fixed asset
	 * 
	 * @author ingalexandrasarmiento
	 * @return ResponseDTO<List<TypeAssetDTO>>
	 */
	@Override
	public ResponseDTO<List<TypeAssetDTO>> findAll() {
		List<TypeAsset> types = typeAssetRepository.findAll();
		if (!types.isEmpty()) {
			return new ResponseDTO<>(typeAssetMapper.typeAssetListToTypeAssetDTOList(types), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
		}

		return new ResponseDTO<>(null, ApiResponseCode.LIST_EMPTY.getCode(), ApiResponseCode.LIST_EMPTY.getDescription(), ApiResponseCode.LIST_EMPTY.getStatus());
	}

}
