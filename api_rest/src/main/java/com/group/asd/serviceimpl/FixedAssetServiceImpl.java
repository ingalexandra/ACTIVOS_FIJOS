package com.group.asd.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.group.asd.util.ApiResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.asd.dto.FixedAssetDTO;
import com.group.asd.dto.FilterDTO;
import com.group.asd.dto.ResponseDTO;
import com.group.asd.entity.FixedAsset;
import com.group.asd.mapper.FixedAssetMapper;
import com.group.asd.repository.FixedAssetRepository;
import com.group.asd.service.IFixedAssetService;

@Service
public class FixedAssetServiceImpl implements IFixedAssetService {
		
	@Autowired
	private FixedAssetMapper fixedAssetMapper;
	@Autowired
	private FixedAssetRepository fixedAssetRepository;
	
	/**
	 * Search for a fixed asset by id
	 * 
	 * @author ingalexandrasarmiento
	 * @param id ID of fixed asset
	 * @return ResponseDTO<FixedAssetDTO>
	 */
	public ResponseDTO<FixedAssetDTO> findById(Integer id) {
		Optional<FixedAsset> faOpc = fixedAssetRepository.findById(id);
		if (faOpc.isPresent()) {
			FixedAsset fa = faOpc.get();
			return new ResponseDTO<>(fixedAssetMapper.fixedAssetToFixedAssetDTO(fa), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
		}
		
		return new ResponseDTO<>(null, ApiResponseCode.DATA_NOT_FOUND.getCode(), ApiResponseCode.DATA_NOT_FOUND.getDescription(), ApiResponseCode.DATA_NOT_FOUND.getStatus());
	}
	

	/**
	 * Search for fixed assets based on the filter applied
	 * 
	 * @author ingalexandrasarmiento
	 * @param filter Filter by type, date of purchase and serial
	 * @return ResponseDTO<List<FixedAssetDTO>>
	 */
	@Override
	public ResponseDTO<List<FixedAssetDTO>> searchByFilter(FilterDTO filter) {
		List<FixedAsset> fixedAssets = fixedAssetRepository.searchFixedAssetsByFilter(filter.getType(), filter.getPurchaseDate(), filter.getSerialNumber());
		if (!fixedAssets.isEmpty()) {
			return new ResponseDTO<>(fixedAssetMapper.fixedAssetListToFixedAssetDTOList(fixedAssets), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
		}

		return new ResponseDTO<>(null, ApiResponseCode.LIST_EMPTY.getCode(), ApiResponseCode.LIST_EMPTY.getDescription(), ApiResponseCode.LIST_EMPTY.getStatus());
	}

	/**
	 * Save or update a fixed asset
	 * 
	 * @author ingalexandrasarmiento
	 * @param fixedAssetDTO Fixed asset to save
	 * @return ResponseDTO<FixedAssetDTO>
	 */
	@Override
	public ResponseDTO<FixedAssetDTO> saveFixedAsset(FixedAssetDTO fixedAssetDTO) {
		if (fixedAssetDTO.getIdArea() != null) {
			fixedAssetDTO.setIdPerson(null);
		} else if (fixedAssetDTO.getIdPerson() != null) {
			fixedAssetDTO.setIdArea(null);
		}
		FixedAsset fa = fixedAssetRepository.save(fixedAssetMapper.fixedAssetDTOToFixedAsset(fixedAssetDTO));
		return new ResponseDTO<>(fixedAssetMapper.fixedAssetToFixedAssetDTO(fa), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
	}
	
}
