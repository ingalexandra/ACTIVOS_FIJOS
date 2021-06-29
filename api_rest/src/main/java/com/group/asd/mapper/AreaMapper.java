package com.group.asd.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group.asd.dto.AreaDTO;
import com.group.asd.entity.Area;

@Mapper(componentModel = "spring")
public interface AreaMapper {
	
	AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);
	
	/**
	 * Convert an area DTO to an area entity
	 * 
	 * @author ingalexandrasarmiento
	 * @param areaDTO
	 * @return Area
	 */
	Area areaDTOToArea(AreaDTO areaDTO);
	
	/**
	 * Convert an area entity to an area DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param area
	 * @return AreaDTO
	 */
	AreaDTO areaToAreaDTO(Area area);
	
	/**
	 * Convert a list of area entities to a list of area DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param areaList
	 * @return List<AreaDTO>
	 */
	List<AreaDTO> areaListToAreaDTOList(List<Area> areaList);

}
