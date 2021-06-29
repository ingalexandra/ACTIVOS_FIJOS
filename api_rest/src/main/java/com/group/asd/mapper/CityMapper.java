package com.group.asd.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group.asd.dto.CityDTO;
import com.group.asd.entity.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

	CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
	
	/**
	 * Convert a city DTO to a city entity
	 * 
	 * @author ingalexandrasarmiento
	 * @param cityDTO
	 * @return City
	 */
	City cityDTOToCity(CityDTO cityDTO);
	
	/**
	 * Convert a city entity to a city DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param city
	 * @return CityDTO
	 */
	CityDTO cityToCityDTO(City city);
	
	/**
	 * Convert a list of cities entities to a list of cities DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param citiesList
	 * @return List<CityDTO>
	 */
	List<CityDTO> areaListToAreaDTOList(List<City> citiesList);
	
}
