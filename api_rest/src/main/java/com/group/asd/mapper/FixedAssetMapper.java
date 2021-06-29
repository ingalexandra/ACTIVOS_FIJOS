package com.group.asd.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group.asd.dto.FixedAssetDTO;
import com.group.asd.entity.FixedAsset;

@Mapper(componentModel = "spring")
public interface FixedAssetMapper {
	
	FixedAssetMapper INSTANCE = Mappers.getMapper(FixedAssetMapper.class);
	
	/**
	 * Convert the fixed assets entity to a DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param fixedAssetDTO
	 * @return FixedAsset
	 */
	FixedAsset fixedAssetDTOToFixedAsset(FixedAssetDTO fixedAssetDTO);
	
	/**
	 * Convert the fixed assets DTO to a entity
	 * 
	 * @author ingalexandrasarmiento
	 * @param fixedAsset
	 * @return FixedAssetDTO
	 */
	FixedAssetDTO fixedAssetToFixedAssetDTO(FixedAsset fixedAsset);
	
	/**
	 * Convert a list of fixed asset entities to a DTO list of fixed assets
	 * 
	 * @author ingalexandrasarmiento
	 * @param fixedAssetsList
	 * @return List<FixedAssetDTO>
	 */
	List<FixedAssetDTO> fixedAssetListToFixedAssetDTOList(List<FixedAsset> fixedAssetsList);

}
