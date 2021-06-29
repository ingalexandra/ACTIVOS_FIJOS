package com.group.asd.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.asd.dto.CityDTO;
import com.group.asd.dto.ResponseDTO;
import com.group.asd.entity.City;
import com.group.asd.mapper.CityMapper;
import com.group.asd.repository.CityRepository;
import com.group.asd.service.ICityService;
import com.group.asd.util.ApiResponseCode;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * Returns all cities
	 * 
	 * @author ingalexandrasarmiento
	 * @return ResponseDTO<List<AreaDTO>>
	 */
	@Override
	public ResponseDTO<List<CityDTO>> findAll() {
		List<City> cities = cityRepository.findAll();
		if (!cities.isEmpty()) {
			return new ResponseDTO<>(cityMapper.areaListToAreaDTOList(cities), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
		}

		return new ResponseDTO<>(null, ApiResponseCode.LIST_EMPTY.getCode(), ApiResponseCode.LIST_EMPTY.getDescription(), ApiResponseCode.LIST_EMPTY.getStatus());
	}

	
	
}
