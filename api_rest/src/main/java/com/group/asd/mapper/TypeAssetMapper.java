package com.group.asd.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group.asd.dto.TypeAssetDTO;
import com.group.asd.entity.TypeAsset;

@Mapper(componentModel = "spring")
public interface TypeAssetMapper {
	
	TypeAssetMapper INSTANCE = Mappers.getMapper(TypeAssetMapper.class);
	
	/**
	 * Convert a Type Asset DTO to a Type Asset entity
	 * 
	 * @author ingalexandrasarmiento
	 * @param typeAssetDTO
	 * @return TypeAsset
	 */
	TypeAsset typeAssetDTOToTypeAsset(TypeAssetDTO typeAssetDTO);
	
	/**
	 * Convert a Type Asset entity to a Type Asset DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param typeAssset
	 * @return TypeAssetDTO
	 */
	TypeAssetDTO typeAssetToTypeAssetDTO(TypeAsset typeAssset);
	
	/**
	 * Convert a list of fixes assets types entities to a list of fixes assets types DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param typesList
	 * @return List<TypeAssetDTO>
	 */
	List<TypeAssetDTO> typeAssetListToTypeAssetDTOList(List<TypeAsset> typesList);

}
